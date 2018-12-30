package com.example.toutiao.mapper;

import com.example.toutiao.pojo.User;
import com.example.toutiao.pojo.UserExample;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
}