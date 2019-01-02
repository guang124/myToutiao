package com.example.toutiao.controller;
import com.example.toutiao.pojo.News;
import com.example.toutiao.pojo.ViewObject;
import com.example.toutiao.service.NewsService;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class homeController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;
private List<ViewObject> getNews(int userId,int offset,int limit){
    List<News> newsList =newsService.findNewsByUserIdAndOffset(userId,offset,limit);
    List<ViewObject> vos=new ArrayList<>();
    for (News news: newsList){
        ViewObject vo=new ViewObject();
        vo.set("news",news);
        vo.set("user",userService.findUserById(news.getUserId()));
        vos.add(vo);
    }
    return vos;
}
    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("vos",getNews(0,0,10));
        return "home";
    }
    @RequestMapping(path = {"/user/{userId}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("vos",getNews(userId,0,10));
        return "home";
    }


}
