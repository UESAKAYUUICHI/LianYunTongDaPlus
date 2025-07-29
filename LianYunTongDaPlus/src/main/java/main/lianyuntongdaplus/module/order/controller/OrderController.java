package main.lianyuntongdaplus.module.order.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.commen.utils.result.MyResult;
import main.lianyuntongdaplus.module.order.domain.Order;
import main.lianyuntongdaplus.module.order.form.GetDataOrderForm;
import main.lianyuntongdaplus.module.order.form.SearchOrdersForm;
import main.lianyuntongdaplus.module.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 新增订单
     * */
    @PostMapping("/addOrder")
    public MyResult addOrder(@RequestBody Order order){
        try{
            orderService.addOrder(order);
            return MyResult.result(order, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

    /**
     * 删除订单
     * */
    @PostMapping("/deleteOrder")
    public MyResult deleteOrder(@RequestBody GetDataOrderForm form){
        Integer id = form.getId();
        try{
            orderService.deleteOrderById(id);
            return MyResult.result(id, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }


    /**
     * 查询订单
     * */
    @PostMapping("/searchOrders")
    public MyResult searchOrders(@RequestBody SearchOrdersForm form){
        try{
            List<Order> orders = orderService.searchOrders(form);
            return MyResult.result(orders, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }


    /**
     * 编辑订单初始化
     * */
    @PostMapping("/iniEdit")
    public MyResult iniEdit(@RequestBody GetDataOrderForm form){
        Integer id = form.getId();
        try{
            Order order = orderService.iniEdit(id);
            return MyResult.result(order, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

    /**
     * 编辑订单提交
     * */
    @PostMapping("/editOrder")
    public MyResult editOrder(@RequestBody Order order){
        try{
            orderService.editOrder(order);
            return MyResult.result(null, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }
}
