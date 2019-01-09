package com.netease.dto;

import com.netease.model.Order;
import com.netease.model.OrderContent;
import org.apache.ibatis.annotations.Param;

/**
 * @author hejiecheng
 * @Date 2019/1/9
 */
public interface OrderDao {

    int addOrder(Order order) ;

    int addOrderContent(OrderContent orderContent) ;

}
