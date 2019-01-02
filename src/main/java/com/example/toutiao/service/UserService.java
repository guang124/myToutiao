package com.example.toutiao.service;

import com.example.toutiao.mapper.LoginTicketMapper;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.pojo.LoginTicket;
import com.example.toutiao.pojo.User;
import com.example.toutiao.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserMapper userDao;
    @Autowired
    LoginTicketMapper loginTicketDao;

    public User findUserById(Integer id){
        return userDao.selectById(id);
    }
    public void  addUser(User user){
        userDao.addUser(user);
    }
    public void updatePassword(User user){
        userDao.updatePassword(user);
    }
    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDao.selectByName(username);

        if (user != null) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDao.addUser(user);

        // 登陆
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDao.selectByName(username);

        if (user == null) {
            map.put("msgname", "用户名不存在");
            return map;
        }

        if (!ToutiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("msgpwd", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDao.addTicket(ticket);
        return ticket.getTicket();
    }

    public User getUser(int id) {
        return userDao.selectById(id);
    }

    public void logout(String ticket) {
        loginTicketDao.updateStatus(ticket, 1);
    }
}
