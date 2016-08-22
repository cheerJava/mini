package com.cheer.mini.test;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.ums.dao.UserDao;
import com.cheer.mini.ums.model.User;


/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test，junit
 * @author Lucy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml"})
public class UserDaoTest {
    
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";

    private int hashIterations = 2;
    
    @Autowired
    private UserDao userDao;

    @Test
    public void testGetByAccount() {
       String account = "lucy";
       
       User user = userDao.get(account);
    }

    @Test
    public void testGet() {
       String id = "442581E35D8911E68C9F3C970ED7EF76";
       
       User user = userDao.get(id);
    }
    
    @Test
    public void testSave() {
       
       User user = new User();
       user.setId("ADMIN1E35D8911E68C9F3C970ED7EF76");
       user.setAccount("admin");
       user.setCreatorFk("ADMIN1E35D8911E68C9F3C970ED7EF76");
       user.setUpdaterFk("ADMIN1E35D8911E68C9F3C970ED7EF76");
       user.setGender((short)1);
       user.setName("超级管理员");
       user.setNickname("超级管理员");
       user.setPassword("123456");
       user.setAccountTypeFk(200);
       user.setSalt(randomNumberGenerator.nextBytes().toHex());
       String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
       user.setPassword(newPassword);
       userDao.save(user);
      
       
       
    }
}
