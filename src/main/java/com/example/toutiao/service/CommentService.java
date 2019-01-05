package com.example.toutiao.service;

import com.example.toutiao.mapper.CommentMapper;
import com.example.toutiao.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentDao;

    public int  getCommentCount(int entityId,int entityType){
       return commentDao.getCommentCount(entityId,entityType);
    }
    public void addComment(Comment comment){
         commentDao.addComment(comment);
    }
    public List<Comment> getCommentByEntity(int entityId, int entityType){
        return   commentDao.selectByEntity(entityId,entityType);
    }
}
