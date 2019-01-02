package com.example.toutiao.interceptor;

import com.example.toutiao.mapper.LoginTicketMapper;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.pojo.HostHolder;
import com.example.toutiao.pojo.LoginTicket;
import com.example.toutiao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginTicketMapper loginTicketDao;
    @Autowired
    private UserMapper userDao;
    @Autowired
    private HostHolder hostHolder;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket=null;
        Cookie[] cookie=request.getCookies();
        if (cookie!=null){
            for (Cookie ck:cookie){
                if (ck.getName().equals("ticket")){
                    ticket=ck.getValue();
                    break;
                }
            }
        }
        if (!StringUtils.isEmpty(ticket)){
           LoginTicket loginTicket= loginTicketDao.selectByTicket(ticket);
           if (loginTicket==null || loginTicket.getExpired().before(new Date()) ||loginTicket.getStatus()!=0){
               return true;
           }
            User user=userDao.selectById(loginTicket.getUserId());
           hostHolder.setUser(user);
        }
        return true;//true表示继续流程
    }

    //处理结束之后，模板渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView!=null && hostHolder.getUser()!=null){
            modelAndView.addObject("user",hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
