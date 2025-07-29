package main.lianyuntongdaplus.module.order.form;


/**
 * 查询表单类
 * */
public class SearchOrdersForm {
    //订单id
    private Integer orderId;
    //订单名称
    private String orderName;

    public SearchOrdersForm(){}
    public SearchOrdersForm(Integer orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    /**
     * 重写toString方法
     * */
    @Override
    public String toString() {
        return "SearchOrdersForm{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
