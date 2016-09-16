package com.cheer.mini.base.util.jsp;

import java.util.List;

import com.cheer.mini.base.spring.SpringContextHolder;
import com.cheer.mini.base.util.CacheUtil;
import com.cheer.mini.ums.dao.DictMapper;
import com.cheer.mini.ums.model.Dict;
import com.cheer.mini.ums.model.DictExample;

public final class DictUtil {
	
	private static final Byte IS_VALID = new Byte((byte) 1);
	
	public static List<Dict> list(String type){
		DictMapper dictMapper=SpringContextHolder.getBean(DictMapper.class);
		Object obj = CacheUtil.get(type);
		if(obj == null){
			DictExample example = new DictExample();
			example.createCriteria().
				andIsValidEqualTo(IS_VALID).
				andTypeEqualTo(type);
			List<Dict> list = dictMapper.selectByExample(example);
			CacheUtil.put(type, list);
		}
		return (List<Dict>) CacheUtil.get(type);
	}
}
