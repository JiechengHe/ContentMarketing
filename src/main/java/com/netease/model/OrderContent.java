package com.netease.model;

import java.math.BigDecimal;

/**
 * @author hejiecheng
 * @Date 2019/1/9
 */
public class OrderContent {

    private int orderId ;
    private int contentId ;
    private BigDecimal price ;
    private int cnt ;

    private Content content ;
    private Order order ;

    public OrderContent() {
    }

    public OrderContent(int orderId, int contentId, BigDecimal price, int cnt) {
        this.orderId = orderId;
        this.contentId = contentId;
        this.price = price;
        this.cnt = cnt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
