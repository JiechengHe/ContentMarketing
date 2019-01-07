package com.netease.dto;

import com.netease.model.Content;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public interface ContentDao {

    int addContent(Content content) ;

    int deleteContent(int id) ;

    int updateContent(Content content) ;

    Content getContent(int id) ;

    List<Content> getAllContent() ;

}
