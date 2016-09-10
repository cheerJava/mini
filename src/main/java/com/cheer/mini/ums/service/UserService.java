package com.cheer.mini.ums.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.exception.ServiceException;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.dto.request.registerRequest;
import com.cheer.mini.ums.model.User;

/**
 * 站在使用者的角度去设计接口
 * 
 * @author Lucy
 * 
 */
public interface UserService {

	public User getByAccount(String account);

	public User adminLogin(String account, String password)
			throws ServiceException;

	public List<User> listUser(User condition);

	Integer count(User condition);
	public User info(String userId);

	List<User> list(User condition, Page page);
	
	public User insertUser(User user);

	public void updateByPrimaryKey(User record);

	User insertcreatUser(User userParam) throws ServiceException;

	int createUser(CustomerUserCreateRequest userParam) throws ServiceException;
	
	public List<User> searchUser(User condition);
	
	
}
