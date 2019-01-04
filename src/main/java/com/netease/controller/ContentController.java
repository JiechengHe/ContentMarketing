package com.netease.controller;

import com.netease.model.Content;
import com.netease.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */
@Controller
@RequestMapping("/Content")
public class ContentController {

    @Autowired
    private ContentService contentService ;

    @RequestMapping(method = RequestMethod.GET)
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

    @RequestMapping(method = RequestMethod.PUT)
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

    @RequestMapping(method = RequestMethod.DELETE)
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


}
