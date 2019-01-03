package com.netease.service;


import com.netease.dto.AdminDao;
import com.netease.dto.BuyerDao;
import com.netease.model.Admin;
import com.netease.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hejiecheng
 * @Date 2019/1/3
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BuyerDao buyerDao ;

    @Autowired
    private AdminDao adminDao ;

    @Override
    public String checkLoginInfo(String username, String password) {
        Buyer buyer = buyerDao.getBuyerInfo(username) ;
        if(buyer != null){
            if(password.equals(buyer.getPassword())){
                return "buyer" ;
            }
        }
        Admin admin = adminDao.getAdminInfo(username) ;
        if(admin != null){
            if(password.equals(admin.getPassword())){
                return "seller" ;
            }
        }
        return null;
    }
}
