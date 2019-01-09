package com.netease.service;

import com.netease.dto.CartDao;
import com.netease.dto.ContentDao;
import com.netease.model.Cart;
import com.netease.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
