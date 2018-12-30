package com.example.toutiao;

import com.example.toutiao.mapper.NewsMapper;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.pojo.News;
import com.example.toutiao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDatabaseTests {
    @Autowired
    private UserMapper userDao;
    @Autowired
    private NewsMapper newsDao;
    @Test
    public void contextLoads() {
        Random random = new Random();
        for (int i = 0; i < 11; ++i) {
//            User user = new User();
//            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
//            user.setName(String.format("USER%d", i));
//            user.setPassword("");
//            user.setSalt("");
//            userDao.addUser(user);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
            news.setLikeCount(i+1);
            news.setUserId(i+1);
            news.setTitle(String.format("TITLE{%d}", i));
            news.setLink(String.format("http://www.nowcoder.com/%d.html", i));
            newsDao.addNews(news);
        }


    }

}

