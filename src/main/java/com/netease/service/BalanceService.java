package com.netease.service;

import com.netease.model.Cart;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/8
 */
public interface BalanceService {

    boolean addCartContent(String username, int contentId, int cnt) ;

    List<Cart> getCart(String username) ;

    boolean deleteCart(String username, int contentId) ;
}
