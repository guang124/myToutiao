package com.example.toutiao.service;

import com.example.toutiao.mapper.NewsMapper;
import com.example.toutiao.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public List<News> findNewsByUserIdAndOffset(Integer userId, int offset, int limit){
        return newsMapper.selectByUserIdAndOffset(userId,offset,limit);
    }
    void  addNews(News news){
        newsMapper.addNews(news);
    }
    News getById(int id){
        return newsMapper.getById(id);
    }
    void updateCommentCount(int id, int commentCount){
        newsMapper.updateCommentCount(id, commentCount);
    }
    void  updateLikeCount(int id, int likeCount){
        newsMapper.updateLikeCount(id,likeCount);
    }

    public String saveImage(MultipartFile file) {
        return null;
    }
}
