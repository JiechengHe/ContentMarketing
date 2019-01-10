package com.netease.controller;


import com.netease.model.Cart;
import com.netease.model.OrderContent;
import com.netease.service.BalanceService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */
@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService ;

    @RequestMapping(value = "/Cart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addCart(@RequestParam(value = "contentId") int contentId,
                                      @RequestParam(value = "cnt") int cnt,
                                      HttpSession session){
        Map<String,Object> result = new HashMap<>() ;
        result.put("code","300") ;
        String username = (String)session.getAttribute("username") ;
        boolean addResult = balanceService.addCartContent(username, contentId, cnt) ;
        if(addResult){
            result.put("code","200") ;
        }
        return result ;
    }

    @RequestMapping(value = "/Cart", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCart(HttpSession session, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>() ;
        result.put("code", "200") ;
        String username = (String)session.getAttribute("username") ;
        List<Cart> carts = balanceService.getCart(username) ;
        result.put("cart", carts) ;
        List<Map<String,Object>> cookieCarts = new ArrayList<>() ;
        for(Cart cart : carts){
            Map<String,Object> oneCart = new HashMap<>() ;
            oneCart.put("contentId", cart.getContentId()) ;
            oneCart.put("cnt", cart.getCnt()) ;
            cookieCarts.add(oneCart) ;
        }
        Cookie cookie = new Cookie("cart", (new JSONArray(cookieCarts)).toString()) ;
        cookie.setPath("/");
        response.addCookie(cookie);
        return result ;
    }

    @RequestMapping(value = "/Cart", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteCart(HttpSession session, @RequestParam(value = "contentId") int contentId){
        Map<String,Object> result = new HashMap<>() ;
        result.put("code", "300") ;
        String username = (String)session.getAttribute("username") ;
        boolean deleteResult = balanceService.deleteCart(username, contentId) ;
        if(deleteResult){
            result.put("code", "200") ;
        }
        return result ;
    }

    @RequestMapping(value = "/ShowCart", method = RequestMethod.GET)
    public String showCart(){
        return "cart" ;
    }

    @RequestMapping(value = "/Order", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> buyOrder(@RequestParam(value = "cartString") String cartString, HttpSession session){
        Map<String,Object> result = new HashMap<>() ;
        result.put("code", "300") ;
        String username = (String)session.getAttribute("username") ;
        JSONArray cartArray = new JSONArray(cartString) ;
        if(cartArray.length() != 0){
            boolean buyResult = balanceService.buyCart(cartArray, username) ;
            if(buyResult){
                result.put("code","200") ;
            }
        }
        return result ;
    }

    @RequestMapping(value = "/Account/getAccount", method = RequestMethod.POST)
    @ResponseBody
    public List<OrderContent> getAccount(HttpSession session){
        String username = (String)session.getAttribute("username") ;
        return balanceService.getAccount(username) ;
    }

    @RequestMapping(value = "/Account", method = RequestMethod.GET)
    public String showAccount(){
        return "account" ;
    }

}
