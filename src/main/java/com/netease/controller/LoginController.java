package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/Login")
    @ResponseBody
    public Map<String,Object> checkLogin(@RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password){
        Map<String,Object> result = new HashMap<>() ;
        return result ;
    }

}
