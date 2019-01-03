package com.netease.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hejiecheng
 * @Date 2019/1/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/config/spring/spring-mvc.xml","/config/spring/spring-mybatis.xml"})
@Transactional
public class LoginServiceTest {

    @Autowired
    private LoginService loginService ;

    @Test
    public void testCheckBuyerLogin(){
        String result = loginService.checkLoginInfo("Buyer","37254660e226ea65ce6f1efd54233424") ;
        System.out.println(result);
    }

    @Test
    public void testCheckAdminLogin(){
        String result = loginService.checkLoginInfo("Seller","981c57a5cfb0f868e064904b8745766f") ;
        System.out.println(result);
    }

    @Test
    public void testCheckUnusernameLogin(){
        String result = loginService.checkLoginInfo("Selle","981c57a5cfb0f868e064904b8745766f") ;
        System.out.println(result);
    }

    @Test
    public void testCheckUnpasswordLogin(){
        String result = loginService.checkLoginInfo("Seller","981c57a5cfb0f868e064904b8745766") ;
        System.out.println(result);
    }

}
