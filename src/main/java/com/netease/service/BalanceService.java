package com.netease.service;

import com.netease.model.Cart;
import com.netease.model.OrderContent;
import org.json.JSONArray;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/8
 */
public interface BalanceService {

    boolean addCartContent(String username, int contentId, int cnt) ;

    List<Cart> getCart(String username) ;

    boolean deleteCart(String username, int contentId) ;

    boolean buyCart(JSONArray cartArray, String username) ;

    List<OrderContent> getAccount(String username) ;
}
