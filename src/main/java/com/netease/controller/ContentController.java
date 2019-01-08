package com.netease.controller;

import com.netease.model.Content;
import com.netease.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService ;

    @RequestMapping(value = "/Content/Info",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getContentInfo(@RequestParam(value = "id") int id){
        Content content = contentService.getContent(id) ;
        Map<String, Object> result = new HashMap<>() ;
        if(content == null){
            result.put("code" , "300") ;
        }
        else{
            result.put("code", "200") ;
            result.put("content", content) ;
        }
        return result ;
    }

    @RequestMapping(value = "/Content",method = RequestMethod.GET)
    public String showInfoDetialPage(@RequestParam(value = "id") int id, HttpServletResponse response){
        Cookie cookie = new Cookie("contentId", id+"") ;
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "contentDetial" ;
    }


    @RequestMapping(value = "/ContentEdit",method = RequestMethod.GET)
    public String showInfoEditPage(@RequestParam(value = "id") int id, HttpServletResponse response){
        Cookie cookie = new Cookie("contentId", id+"") ;
        cookie.setPath("/");
        if(id >= 0){
            cookie.setMaxAge(5);
        }
        else{
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        return "contentEdit" ;
    }

    @RequestMapping(value = "/Content/Info",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> addContentInfo(Content content){
        Map<String, Object> result = new HashMap<>() ;
        boolean insertResult = contentService.addContent(content) ;
        if(insertResult){
            result.put("code", 200) ;
        }
        else{
            result.put("code", 300) ;
        }
        return result ;
    }

    @RequestMapping(value = "/Content/Info",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteContentInfo(@RequestParam(value = "id") int id){
        Map<String,Object> result = new HashMap<>() ;
        boolean deleteResult = contentService.deleteContent(id) ;
        if(deleteResult){
            result.put("code", 200) ;
        }
        else{
            result.put("code", 300) ;
        }
        return result ;
    }

    @RequestMapping(value = "/Content/Info",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateContentInfo(Content content){
        Map<String,Object> result = new HashMap<>() ;
        boolean updateResult = contentService.updateContent(content) ;
        if(updateResult){
            result.put("code", 200) ;
        }
        else{
            result.put("code", 300) ;
        }
        return result ;
    }


}
