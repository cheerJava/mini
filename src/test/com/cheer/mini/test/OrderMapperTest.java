package com.cheer.mini.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.dao.OrderMapper;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
public class OrderMapperTest {
	
	private Logger logger = Logger.getLogger(this.getClass().getName()); 
    
	@Autowired
    private OrderMapper orderMapper;
	
	
	@Test
	public void testCount(){
		OrderExample example = new OrderExample();
		example.createCriteria().andTitleLike("Uter%")
			.andStatusEqualTo((byte)1);
		Integer rt = orderMapper.selectCountByExample(example);
		logger.info("rt : " + rt);
		
	}
	
	@Test
	public void testSelectExample(){
		OrderExample example = new OrderExample();
		Page page = new Page();
		Integer total = orderMapper.selectCountByExample(example);
		page.cal(total);
		page.setPageNo(1);
		example.setPage(page);
		
		List<Order> rt = orderMapper.selectByExample(example);
		
		logger.info("rt : " + rt);
		
	}
	
}
