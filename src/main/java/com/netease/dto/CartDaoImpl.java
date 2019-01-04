package com.netease.dto;

/**
 * @author hejiecheng
 * @Date 2019/1/4
 */
public class CartDaoImpl extends BaseDao implements CartDao {

    @Override
    public int deleteCartContent(int contentId) {
        return this.getSqlSession().delete("deleteCartContent", contentId) ;
    }
}
