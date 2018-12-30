package com.example.toutiao.service;

import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserMapper userMapper;
    User findUserById(Integer id){

        return userMapper.selectById(id);
    }
    void  addUser(User user){
        userMapper.addUser(user);
    }
    void updatePassword(User user){
        userMapper.updatePassword(user);
    }
    void deleteById(Integer id){
        userMapper.deleteById(id);
    }
}
