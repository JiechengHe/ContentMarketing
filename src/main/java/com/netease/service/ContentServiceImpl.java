package com.netease.service;

import com.netease.dto.CartDao;
import com.netease.dto.ContentDao;
import com.netease.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao ;

    @Autowired
    private CartDao cartDao ;


    @Override
    public boolean addContent(Content content) {
        boolean result = false ;
        try {
            int inserted = contentDao.addContent(content);
            if(inserted == 1){
                result = true ;
            }
        }
        catch (DataAccessException e){
            // 写日志
        }
        return result;
    }

    @Override
    public boolean updateContent(Content content) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteContent(int id) {

        cartDao.deleteCartContent(id) ;
        int result = contentDao.deleteContent(id) ;
        if(result == 0){
            return false ;
        }
        return true ;
    }

    @Override
    public Content getContent(int id) {
        Content content = contentDao.getContent(id) ;
        // 判断对象中是否有null值
        if(content == null){
            return null ;
        }

        if(content.getTitle() == null){
            return null ;
        }
        return content ;
    }

    @Override
    public List<Content> getAllContent() {
        return contentDao.getAllContent() ;
    }
}
