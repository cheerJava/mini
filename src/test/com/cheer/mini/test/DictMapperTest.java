package com.cheer.mini.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.base.spring.SpringContextHolder;
import com.cheer.mini.base.util.StringUtil;
import com.cheer.mini.ums.dao.DictMapper;
import com.cheer.mini.ums.model.Dict;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
public class DictMapperTest {
	
	//@Autowired
	//private DictMapper dictMapper;
	
	private static final String ADMIN_ID = "ADMIN1E35D8911E68C9F3C970ED7EF76";
	
	@Test
	public void testInit(){
		
		DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);
		
		Date currentTime = new Date();
		{
			Dict dict = new Dict();
			dict.setId(StringUtil.createUUID());
			dict.setValue(1);
			dict.setLabel("男");
			dict.setType("gender");
			dict.setDescription("性别男");
			dict.setSort(1L);
			dict.setCreatorFk(ADMIN_ID);
			dict.setUpdaterFk(ADMIN_ID);
			dict.setDateCreate(currentTime);
			dict.setDateUpdate(currentTime);	
			dictMapper.insert(dict);
		}
		{
			Dict dict = new Dict();
			dict.setId(StringUtil.createUUID());
			dict.setValue(2);
			dict.setLabel("女");
			dict.setType("gender");
			dict.setDescription("性别女");
			dict.setSort(2L);
			dict.setCreatorFk(ADMIN_ID);
			dict.setUpdaterFk(ADMIN_ID);
			dict.setDateCreate(currentTime);
			dict.setDateUpdate(currentTime);
			dictMapper.insert(dict);
		}
		
		
	}
}
