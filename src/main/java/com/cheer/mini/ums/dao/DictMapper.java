package com.cheer.mini.ums.dao;

import com.cheer.mini.ums.model.Dict;
import com.cheer.mini.ums.model.DictExample;
import java.util.List;

public interface DictMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
}