package com.cheer.mini.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.dao.UserMapper;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.model.UserExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-dao.xml", "classpath:config/spring-service.xml" })
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Test
	public void testCount() {
		UserExample example = new UserExample();
		Page page = new Page();
		Integer total = userMapper.selectCountByExample(example);
		page.cal(total);
		page.setPageNo(2);
		example.setPage(page);
		List<User> rt = userMapper.selectByExample(example);
		logger.info("rt:" + rt);
	}

}
