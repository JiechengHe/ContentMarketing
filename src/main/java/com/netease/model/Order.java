package com.netease.model;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/9
 */
public class Order {

    private int orderId ;
    private String userId ;
    private int orderTime ;

    List<OrderContent> contents ;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderContent> getContents() {
        return contents;
    }

    public void setContents(List<OrderContent> contents) {
        this.contents = contents;
    }
}
