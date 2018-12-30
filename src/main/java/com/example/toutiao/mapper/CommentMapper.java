package com.example.toutiao.mapper;

import com.example.toutiao.pojo.Comment;
import com.example.toutiao.pojo.CommentExample;
import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);
}