package com.netease.controller;

import com.netease.model.Content;
import com.netease.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hejiecheng
 * @Date 2019/1/2
 */

@Controller
@RequestMapping("/List")
public class ListController {

    @Autowired
    private ContentService contentService ;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> indexList(){
        Map<String,Object> map = new HashMap<>() ;
        List<Content> contentList = contentService.getAllContent() ;
        if(contentList == null){
            map.put("code","300") ;
        }
        else {
            map.put("code", "200");
            map.put("data", contentList) ;
        }
        return map;
    }


}
