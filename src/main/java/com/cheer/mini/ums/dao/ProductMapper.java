package com.cheer.mini.ums.dao;

import com.cheer.mini.ums.model.Product;
import com.cheer.mini.ums.model.ProductExample;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    Integer selectCountByExample(ProductExample example);
}