package com.cheer.mini.ums.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cheer.mini.base.Constants;
import com.cheer.mini.base.Page;
import com.cheer.mini.base.exception.ServiceException;
import com.cheer.mini.base.util.StringUtil;
import com.cheer.mini.ums.dao.UserMapper;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.dto.request.registerRequest;

import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.model.UserExample;
import com.cheer.mini.ums.model.UserExample.Criteria;
import com.cheer.mini.ums.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String algorithmName = "md5";

	private int hashIterations = 2;

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserMapper userMapper;

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);
	}

	/**
	 * 验证登录密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean validatePassword(User user, String password) {
		String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(user.getCredentialsSalt()),
				hashIterations).toHex();
		if (newPassword.equals(user.getPassword()))
			return true;
		return false;
	}

	@Override
    public User getByAccount(String account) {
    	UserExample example = new UserExample();
    	example.createCriteria().andAccountEqualTo(account).andIsValidEqualTo(new Byte((byte)1));
        List<User> list = userMapper.selectByExample(example);
        if(list!=null && !list.isEmpty()){
        	return list.iterator().next();
        }
        return null;
    }
	
    @Override
    public User adminLogin(String account, String password) throws ServiceException {
        User user = this.getByAccount(account);
        if (user == null) throw new ServiceException("用户名或密码错误");
        if (user.getAccountTypeFk() != Constants.AccountType.ACCOUNT_TYPE_ADMIN) throw new ServiceException("用户名或密码错误");
        if (!this.validatePassword(user, password)) throw new ServiceException("用户名或密码错误");
        return user;
    }

    @Override
    public int createUser(CustomerUserCreateRequest userParam) throws ServiceException {
        
        if(StringUtil.isEmpty(userParam.getAccount()))throw new ServiceException("用户名不能为空");
        if(StringUtil.isEmpty(userParam.getName()))throw new ServiceException("姓名不能为空");
        if(StringUtil.isEmpty(userParam.getNickname()))throw new ServiceException("昵称不能为空");
        if(StringUtil.isEmpty(userParam.getPassword()))throw new ServiceException("密码不能为空");
        if(!(Constants.Gender.GENDER_MALE==userParam.getGender()||Constants.Gender.GENDER_FEMALE==userParam.getGender()))throw new ServiceException("请选择性别");
        User user = this.getByAccount(userParam.getAccount());
        if(user!=null)throw new ServiceException("该用户名已存在");
        user = new User();      
        user.setAccount(userParam.getAccount());
        user.setGender(userParam.getGender());
        user.setCreatorFk(user.getId());
        user.setUpdaterFk(user.getId());
        user.setName(userParam.getName());
        user.setNickname(userParam.getNickname());
        user.setPassword(userParam.getPassword());
        this.encryptPassword(user);
        return userMapper.insert(user);
       
        
    }



	@Override
	public List<User> listUser(User condition) {
		List<User> list=userMapper.selectByExample(null);
		return list;
	}


	 @Override
	    public User insertcreatUser(User userParam) throws ServiceException {
		 System.out.println("添加1");
	        if(StringUtil.isEmpty(userParam.getAccount()))throw new ServiceException("用户名不能为空");
	        if(StringUtil.isEmpty(userParam.getName()))throw new ServiceException("姓名不能为空");
	        if(StringUtil.isEmpty(userParam.getNickname()))throw new ServiceException("昵称不能为空");
	        if(StringUtil.isEmpty(userParam.getPassword()))throw new ServiceException("密码不能为空");
	        short s=userParam.getGender();
	        if(!(Constants.Gender.GENDER_MALE==userParam.getGender()||Constants.Gender.GENDER_FEMALE==userParam.getGender()))throw new ServiceException("请选择性别");
	        User user = this.getByAccount(userParam.getAccount());
	        if(user!=null)throw new ServiceException("该用户名已存在");
	        user = new User();      
	        user.setAccount(userParam.getAccount());
	        user.setGender(userParam.getGender());
	        user.setCreatorFk(user.getId());
	        user.setUpdaterFk(user.getId());
	        user.setName(userParam.getName());
	        user.setNickname(userParam.getNickname());
	        user.setPassword(userParam.getPassword());
	        this.encryptPassword(user);
	        System.out.println("添加2");
	        int rt =userMapper.insert(user);
	        System.out.println("添加");
	        if(rt == 1){
	        	return user;
	        }else{
	        	return null;
	        }
	    }

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteByPrimaryKey(String orderId) {
		
		userMapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public void updateByPrimaryKeySelective(User record) {
		userMapper.updateByPrimaryKeySelective(record);
		
	}

	@Override
	public User selectByPrimaryKey(String id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> searchUser(User condition) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			if(condition!=null && StringUtil.notEmpty(condition.getName())){
				criteria.andNameLike(condition.getName() + "%");
			}
			if(condition!=null && StringUtil.notEmpty(condition.getNickname())){
				criteria.andNameLike(condition.getNickname() + "%");
			}
			return userMapper.selectByExample(example);
		
		
	}
	
	@Override
	public Integer count(User condition) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(condition!=null && StringUtil.notEmpty(condition.getName())){
			criteria.andNameLike(condition.getName() + "%");
		}
		if(condition!=null && StringUtil.notEmpty(condition.getNickname())){
			criteria.andNameLike(condition.getNickname() + "%");
		}
		return userMapper.selectCountByExample(example);
	}
	
	@Override
	public List<User> list(User condition,Page page) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(page!=null){
			example.setPage(page);
		}	
		return userMapper.selectByExample(example);
	}

	@Override
	public User info(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}