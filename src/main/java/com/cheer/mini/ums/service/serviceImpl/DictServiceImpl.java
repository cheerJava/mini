package com.cheer.mini.ums.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mini.base.util.CacheUtil;
import com.cheer.mini.ums.dao.DictMapper;
import com.cheer.mini.ums.model.Dict;
import com.cheer.mini.ums.model.DictExample;
import com.cheer.mini.ums.service.DictService;

@Service
public class DictServiceImpl implements DictService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private DictMapper dictMapper;
	
	private static final Byte IS_VALID = new Byte((byte) 1);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dict> list(String type) {
		Object obj = CacheUtil.get(type);
		if(obj == null){
			logger.info("Get List<Dict> from DataBase...");
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
