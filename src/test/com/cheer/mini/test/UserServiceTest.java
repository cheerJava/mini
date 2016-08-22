package com.cheer.mini.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    private Logger logger = Logger.getLogger(this.getClass().getName()); 
    
    
    @Test
    public void testGetByAccount() {
        User user = userService.getByAccount("admin");
        logger.info("get user ["+user.getAccount()+"] succeed");
        
    }

    @Test
    public void testLogin() {
       // fail("Not yet implemented");
    }

    @Test
    public void testCreateUser() {
       // fail("Not yet implemented");
    }

}
