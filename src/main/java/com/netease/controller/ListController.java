package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */

@Controller
@RequestMapping("/List")
public class ListController {

    @RequestMapping(value = "/Index", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> indexList(){
        Map<String,String> map = new HashMap<>() ;
        map.put("code","200") ;
        return map;
    }

    @RequestMapping(value = "/Buyer", method = RequestMethod.POST)
    public void buyerList(){}

    @RequestMapping(value = "/Seller", method = RequestMethod.POST)
    public void sellerList(){}

}
