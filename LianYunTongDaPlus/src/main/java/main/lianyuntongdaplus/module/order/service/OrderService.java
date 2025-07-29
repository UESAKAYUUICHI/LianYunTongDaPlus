package main.lianyuntongdaplus.module.order.service;

import main.lianyuntongdaplus.module.order.domain.Order;
import main.lianyuntongdaplus.module.order.form.SearchOrdersForm;

import java.util.List;

public interface OrderService
{
    /**
     * 根据id删除订单
     * */
    void deleteOrderById(Integer id);

    /**
     * 根据id初始化修改订单
     * */
    Order iniEdit(Integer id) throws Exception;

    /**
     * 修改订单提交
     * */
    void editOrder(Order order);

    /**
     * 新增订单
     * */
    void addOrder(Order order);

    /**
     * 订单列表查询
     * */
    List<Order> searchOrders(SearchOrdersForm form);
}
