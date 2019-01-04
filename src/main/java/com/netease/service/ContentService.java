package com.netease.service;

import com.netease.model.Content;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public interface ContentService {

    boolean addContent(Content content) ;

    boolean updateContent(Content content) ;

    boolean deleteContent(int id) ;

    Content getContent(int id) ;

    List<Content> getAllContent() ;

}
