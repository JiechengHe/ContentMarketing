package com.netease.service;

import com.netease.dto.CartDao;
import com.netease.dto.ContentDao;
import com.netease.dto.OrderDao;
import com.netease.model.Cart;
import com.netease.model.Content;
import com.netease.model.Order;
import com.netease.model.OrderContent;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/8
 */
@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private CartDao cartDao ;

    @Autowired
    private ContentDao contentDao ;

    @Autowired
    private OrderDao orderDao ;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean addCartContent(String username, int contentId, int cnt) {
        Integer nowCnt = cartDao.selectOneContent(username,contentId) ;
        if(nowCnt == null){
            // 新增
            Content content = contentDao.getContent(contentId) ;
            if(content.getCnt() != 0){
                return false ;
            }
            else{
                cartDao.insertCartContent(username, contentId, cnt) ;
                return true ;
            }
        }
        else{
            // 修改数量
            cartDao.updateCartContent(username, contentId, cnt) ;
            return true ;
        }
    }

    @Override
    public List<Cart> getCart(String username) {
        List<Cart> result = cartDao.getCartList(username) ;
        return result ;
    }

    @Override
    public boolean deleteCart(String username, int contentId) {
        int result = cartDao.deleteCart(username, contentId) ;
        if(result != 0){
            return true ;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean buyCart(JSONArray cartArray, String username) {
        Order order = new Order() ;
        order.setUserId(username);
        String time = System.currentTimeMillis() + "";
        time = time.substring(0,10) ;
        order.setOrderTime(Integer.valueOf(time));
        orderDao.addOrder(order) ;
        for(int i = 0 ; i < cartArray.length() ; ++ i){
            int contentId = cartArray.getJSONObject(i).getInt("contentId") ;
            int cnt = cartArray.getJSONObject(i).getInt("cnt") ;
            // 获取price
            Content content = contentDao.getContent(contentId) ;
            if(content == null){
                continue ;
            }
            int deleteResult = cartDao.deleteCart(username, contentId) ;
            if(deleteResult == 0){
                continue ;
            }
            OrderContent orderContent = new OrderContent(order.getOrderId(), contentId, content.getPrice(), cnt) ;
            orderDao.addOrderContent(orderContent) ;
        }
        return true;
    }

    @Override
    public List<OrderContent> getAccount(String username) {
        return orderDao.getAccount(username) ;
    }
}
