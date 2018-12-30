package com.example.toutiao.mapper;

import com.example.toutiao.pojo.loginTicket;
import com.example.toutiao.pojo.loginTicketExample;
import java.util.List;

public interface loginTicketMapper {
    int insert(loginTicket record);

    int insertSelective(loginTicket record);

    List<loginTicket> selectByExample(loginTicketExample example);
}