package com.netease.controller;

import com.netease.service.LoginService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService ;

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String loginPage(){
        return "login" ;
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin(@RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password,
                                         HttpServletRequest request,
                                         HttpServletResponse response,
                                         HttpSession session){
        Map<String,Object> result = new HashMap<>() ;
        String status = loginService.checkLoginInfo(username, password) ;
        if(status == null){
            result.put("code", 300) ;
        }
        else{
            result.put("code", 200) ;
            Cookie cookie = new Cookie("username", status) ;
            cookie.setPath("/");
            response.addCookie(cookie);
            session.setAttribute("username",status);
        }
        return result ;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        Cookie cookie = new Cookie("username", null) ;
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        session.invalidate();
        return "login" ;
    }

}
