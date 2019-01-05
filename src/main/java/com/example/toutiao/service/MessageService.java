package com.example.toutiao.service;

import com.example.toutiao.mapper.MessageMapper;
import com.example.toutiao.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageDao;

    public int addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    public List<Message> getConversationList(int userId, int offset, int limit) {
        // conversation的总条数存在id里
        return messageDao.getConversationList(userId, offset, limit);
    }

    public List<Message> getConversationDetail(String conversationId, int offset, int limit) {
        // conversation的总条数存在id里
        return messageDao.getConversationDetail(conversationId, offset, limit);
    }

    public int getUnreadCount(int userId, String conversationId) {
        return messageDao.getConversationUnReadCount(userId, conversationId);
    }
}
