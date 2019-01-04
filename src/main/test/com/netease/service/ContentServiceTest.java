package com.netease.service;

import com.netease.dto.ContentDao;
import com.netease.model.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/config/spring/spring-mvc.xml","/config/spring/spring-mybatis.xml"})
@Transactional
public class ContentServiceTest {

    @Autowired
    private ContentService contentService ;

    @Test
    public void testAddContent(){
        Content content = new Content("asdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjfasdjfkljsdlkfjskldjflskdjf","b","c","d",new BigDecimal("110.1")) ;
        boolean result = contentService.addContent(content) ;
        System.out.println("result = " + result);
    }

}
