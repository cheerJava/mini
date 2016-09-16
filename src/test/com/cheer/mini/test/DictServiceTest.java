package com.cheer.mini.test;

import java.util.List;

import org.junit.Test;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.ums.model.Dict;
import com.cheer.mini.ums.service.DictService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-dao.xml", "classpath:config/spring-service.xml" })
public class DictServiceTest {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DictService dictService;

	@Test
	public void testDict() {
		long currentTime = System.currentTimeMillis();
		List<Dict> list = dictService.list("gender");
		logger.info("Dict List : " + list);
		long now = System.currentTimeMillis();
		logger.info("Execute time : " + (now - currentTime));
		
		currentTime = System.currentTimeMillis();
		list = dictService.list("gender");
		logger.info("Dict List : " + list);
		now = System.currentTimeMillis();
		logger.info("Execute time : " + (now - currentTime));
		
		currentTime = System.currentTimeMillis();
		list = dictService.list("gender");
		logger.info("Dict List : " + list);
		now = System.currentTimeMillis();
		logger.info("Execute time : " + (now - currentTime));
		
		currentTime = System.currentTimeMillis();
		list = dictService.list("gender");
		logger.info("Dict List : " + list);
		now = System.currentTimeMillis();
		logger.info("Execute time : " + (now - currentTime));
	}

}
