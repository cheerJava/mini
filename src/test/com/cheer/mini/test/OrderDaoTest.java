package com.cheer.mini.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.ums.dao.OrderDao;
import com.cheer.mini.ums.dao.UserDao;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.User;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test，junit
 * 
 * @author Lucy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-dao.xml" })
public class OrderDaoTest {

	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private OrderDao orderDao;

	@Test
	public void testGetOrderInfo() {
		Order order = orderDao.getOrderInfo("BGUBWUZY0G4XHJGYV8ITYGO2Z9TEB6EZ");
		logger.debug(order);
	}
	
	@Test
	public void testList(){
		Order condition = new Order();
		//condition.setStatus(-1);
		condition.setStatus(Order.ORDER_STATUS.DRAFT);
		//condition.setTitle("Uter7");
		List<Order> list = orderDao.list(condition);
		logger.info("List size : " + list.size());
		logger.info("List centent : " + list);
		
	}
	
	
	
}
