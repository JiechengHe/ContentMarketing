package com.netease.controller;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author hejiecheng
 * @Date 2019/1/8
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/Upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpSession session){
        Map<String,Object> result = new HashMap<>() ;
        result.put("code",300) ;

        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1) ;
        String name = System.currentTimeMillis() + "";
        String path = session.getServletContext().getRealPath("/") + "image/" + name + "." + type ;
        File newFile = new File(path) ;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
            result.put("code", 200) ;
            result.put("imgUrl", "image/" + name + "." + type) ;
        }
        catch (IOException ex){
            // 添加日志
        }
        String out=String.valueOf(new JSONObject(result));
        return out ;
    }

}
