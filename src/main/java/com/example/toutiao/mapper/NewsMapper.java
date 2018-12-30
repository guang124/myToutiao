package com.example.toutiao.mapper;

import com.example.toutiao.pojo.News;
import com.example.toutiao.pojo.NewsExample;
import java.util.List;

public interface NewsMapper {
    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);
}