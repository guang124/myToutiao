package com.example.toutiao.mapper;

import com.example.toutiao.pojo.Message;
import com.example.toutiao.pojo.MessageExample;
import java.util.List;

public interface MessageMapper {
    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);
}