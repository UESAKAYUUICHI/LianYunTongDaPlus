package main.lianyuntongdaplus.module.order.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Wuliuorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_content")
    private String orderContent;

    @Column(name = "order_state")
    private String orderState;

    public Order(){}

    public Order(int orderId, String orderName, String orderContent, String orderState) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderContent = orderContent;
        this.orderState = orderState;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderContent='" + orderContent + '\'' +
                ", orderState='" + orderState + '\'' +
                '}';
    }
}
