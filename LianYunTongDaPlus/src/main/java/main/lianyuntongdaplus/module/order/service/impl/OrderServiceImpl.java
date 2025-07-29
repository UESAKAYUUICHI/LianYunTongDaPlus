package main.lianyuntongdaplus.module.order.service.impl;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.order.dao.OrderRepository;
import main.lianyuntongdaplus.module.order.domain.Order;
import main.lianyuntongdaplus.module.order.form.SearchOrdersForm;
import main.lianyuntongdaplus.module.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    /**
     * 新增订单
     * */
    @Override
    public void addOrder(Order order) {
        if(orderRepository.findById(order.getOrderId()).isEmpty()){
            orderRepository.save(order);
        }else{
            throw new RuntimeException("订单已存在");
        }
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteBookById(id);
    }


    /**
     * 根据订单id查询订单
     * */
    @Override
    public List<Order> searchOrders(SearchOrdersForm form) {
        //获取表单中的值
        Integer id = form.getOrderId();
        String name = form.getOrderName();

        //新建返回列表
        List<Order> orders = new ArrayList<>();

        //如果id和name都为空，查询所有订单
        if (id == null && name == null) {
            orders = orderRepository.findAll();
            return orders;
        }

        //查找两个选项，添加到orders列表中
        if(id != null){
            orders.addAll(orderRepository.findByOrderId(id));
        }
        if(name != null){
            orders.addAll(orderRepository.findByOrderNameContaining(name));
        }

        //去重
        orders = orders.stream().distinct().collect(Collectors.toList());
        //返回结果
        return orders;
    }


    /**
     * 初始化编辑模块
     * 打开编辑页面获取值
     **/
    @Override
    public Order iniEdit(Integer id) {
        Order order = orderRepository.findById(id).orElse(null);
        return order;
    }

    /**
     * 修改后的表单提交处理
     */
    @Override
    public void editOrder(Order order) {
        try{
            orderRepository.save(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
