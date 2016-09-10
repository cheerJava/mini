package com.cheer.mini.ums.dao;

import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderExample;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

	Integer selectCountByExample(OrderExample example);
}