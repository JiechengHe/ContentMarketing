package com.netease.dto;

import com.netease.model.Content;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
@Repository
public class ContentDaoImpl extends BaseDao implements ContentDao{

    @Override
    public int addContent(Content content) {
        int result = this.getSqlSession().insert("addContent", content) ;
        return result ;
    }

    @Override
    public int deleteContent(int id) {
        int result = this.getSqlSession().delete("deleteContent", id) ;
        return result ;
    }

    @Override
    public Content getContent(int id) {
        Content content = this.getSqlSession().selectOne("getContent", id) ;
        return content ;
    }

    @Override
    public List<Content> getAllContent() {
        List<Content> contents = this.getSqlSession().selectList("getAllContent") ;
        return contents;
    }

    @Override
    public int updateContent(Content content) {
        int result = this.getSqlSession().update("updateContent", content) ;
        return result ;
    }
}
