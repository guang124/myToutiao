package com.example.toutiao.service;

import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id){
        return userMapper.selectById(id);
    }
    public void  addUser(User user){
        userMapper.addUser(user);
    }
    public void updatePassword(User user){
        userMapper.updatePassword(user);
    }
    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }
}
