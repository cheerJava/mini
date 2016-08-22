package com.cheer.mini.ums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.cheer.mini.ums.dto.request.registerRequest;
import com.cheer.mini.ums.model.User;

public interface UserDao {

    public User getByAccount(String account);

    public User get(String id);

    public User login(String account, String password);

    public int save(User user);
    
    public List<User> listUser();
    
    public int createUser(User user);
    
    public User  insertUser(User user);
}
