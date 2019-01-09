package com.netease.dto;

import com.netease.model.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public interface CartDao {

    int deleteCartContent(int contentId) ;

    int insertCartContent(@Param("username") String username, @Param("contentId") int contentId, @Param("cnt") int cnt) ;

    int updateCartContent(@Param("username") String username, @Param("contentId") int contentId, @Param("cnt") int cnt) ;

    Integer selectOneContent(@Param("username")String username, @Param("contentId") int contentId) ;

    List<Cart> getCartList(@Param("username") String username) ;

    int deleteCart(@Param("username") String username, @Param("contentId") int contentId) ;

}
