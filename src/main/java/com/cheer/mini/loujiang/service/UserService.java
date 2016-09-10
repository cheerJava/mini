package com.cheer.mini.loujiang.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.exception.ServiceException;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.dto.request.registerRequest;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.User;

/**
 * 站在使用者的角度去设计接口
 * 
 * @author Lucy
 * 
 */
public interface UserService {

	public User getByAccount(String account);

	public User adminLogin(String account, String password) throws ServiceException;

	public int createUser(CustomerUserCreateRequest userParam) throws ServiceException;

	public List<User> listUser(Page page);

	public User insertUser(User user);

	public User insertcreatUser(User user) throws ServiceException;

	int updateByPrimaryKeySelective(User record);

	User selectByPrimaryKey(String id);

	void delete(String userId);

	List<User> list(User editinfo);

	List<User> listByAccount(User editinfo);

	public Integer count(User condition);

}
