package com.cheer.mini.test;

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
		Order order = orderDao.getOrderInfo("DJR88LITOEHZL75SFFIRA0JL77IVWHBQ");
		logger.debug(order);
	}
}
