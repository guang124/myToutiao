package com.example.toutiao.service;

import com.example.toutiao.mapper.NewsMapper;
import com.example.toutiao.pojo.News;
import com.example.toutiao.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public List<News> findNewsByUserIdAndOffset(Integer userId, int offset, int limit){
        return newsMapper.selectByUserIdAndOffset(userId,offset,limit);
    }
    public void  addNews(News news){
        newsMapper.addNews(news);
    }
    public News getById(int id){
        return newsMapper.getById(id);
    }
    public void updateCommentCount(int id, int commentCount){
        newsMapper.updateCommentCount(id, commentCount);
    }
    public void  updateLikeCount(int id, int likeCount){
        newsMapper.updateLikeCount(id,likeCount);
    }

    public String saveImage(MultipartFile file) throws IOException {
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if (!ToutiaoUtil.isFileAllowed(fileExt)) {
            return null;
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        Files.copy(file.getInputStream(), new File(ToutiaoUtil.IMAGE_DIR + fileName).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return ToutiaoUtil.TOUTIAO_DOMAIN + "image?name=" + fileName;
    }
}
