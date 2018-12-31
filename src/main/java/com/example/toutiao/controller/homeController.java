package com.example.toutiao.controller;
import com.example.toutiao.pojo.News;
import com.example.toutiao.pojo.ViewObject;
import com.example.toutiao.service.NewsService;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class homeController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model) {
        List<News> newsList =newsService.findNewsByUserIdAndOffset(0,0,10);
        List<ViewObject> vos=new ArrayList<>();
        for (News news: newsList){
            ViewObject vo=new ViewObject();
            vo.set("news",news);
            vo.set("user",userService.findUserById(news.getUserId()));
            vos.add(vo);
        }
        model.addAttribute("vos",vos);
        return "home";
    }


}
