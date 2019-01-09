package com.netease.model;

import java.math.BigDecimal;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public class Content {

    private int id ;
    private String title ;
    private String remark ;
    private String artical ;
    private String picture ;
    private BigDecimal price ;
    private int cnt ;
    private BigDecimal buyPrice ;

    public Content() {}

    public Content(String title, String remark, String artical, String picture, BigDecimal price){
        this.title = title ;
        this.remark = remark ;
        this.artical = artical ;
        this.picture = picture ;
        this.price = price ;
    }

    public Content(int id, String title, String remark, String artical, String picture, BigDecimal price, int cnt) {
        this.id = id;
        this.title = title;
        this.remark = remark;
        this.artical = artical;
        this.picture = picture;
        this.price = price;
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArtical() {
        return artical;
    }

    public void setArtical(String artical) {
        this.artical = artical;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", remark='" + remark + '\'' +
                ", artical='" + artical + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                '}';
    }
}
