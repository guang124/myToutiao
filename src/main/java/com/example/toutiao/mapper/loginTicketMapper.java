package com.example.toutiao.mapper;

import com.example.toutiao.pojo.LoginTicket;
import com.example.toutiao.pojo.LoginTicketExample;
import java.util.List;

public interface LoginTicketMapper {
    int insert(LoginTicket record);

    int insertSelective(LoginTicket record);

    List<LoginTicket> selectByExample(LoginTicketExample example);
}