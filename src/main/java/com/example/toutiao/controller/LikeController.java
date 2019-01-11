package com.example.toutiao.controller;


import com.example.toutiao.pojo.EntityType;
import com.example.toutiao.pojo.HostHolder;
import com.example.toutiao.pojo.News;
import com.example.toutiao.service.LikeService;
import com.example.toutiao.service.NewsService;
import com.example.toutiao.util.ToutiaoUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户点赞的控制
 */
@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    NewsService newsService;

    @RequestMapping(path = {"/like/{newsId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String like(@PathVariable("newsId") int newsId) {
        long likeCount = likeService.like(hostHolder.getUser().getId(), EntityType.ENTITY_NEWS, newsId);
        // 更新喜欢数
        News news = newsService.getById(newsId);
        newsService.updateLikeCount(newsId, (int) likeCount);
        return ToutiaoUtil.getJSONString(0, String.valueOf(likeCount));
    }

    @RequestMapping(path = {"/dislike/{newsId}}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String dislike(@PathVariable("newsId") int newsId) {
        long likeCount = likeService.disLike(hostHolder.getUser().getId(), EntityType.ENTITY_NEWS, newsId);
        // 更新喜欢数
        newsService.updateLikeCount(newsId, (int) likeCount);
        return ToutiaoUtil.getJSONString(0, String.valueOf(likeCount));
    }
}
