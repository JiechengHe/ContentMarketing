package com.netease.model;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public class Cart {

    private String userId ;
    private int contentId ;
    private int cnt ;

    public Cart() {
    }

    public Cart(String userId, int contentId) {
        this.userId = userId;
        this.contentId = contentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
