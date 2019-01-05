package com.example.toutiao.mapper;

import com.example.toutiao.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    String TABLE_NAME = "comment";
    String INSERT_FIELDS = " user_id, content, created_date, entity_id, entity_type, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId},#{content},#{createdDate},#{entityId},#{entityType},#{status})"})
    int addComment(Comment comment);

    @Select({"select ", SELECT_FIELDS , " from ", TABLE_NAME,
            " where entity_id=#{entityId} and entity_type=#{entityType} and status=0 ORDER BY id DESC"})
    List<Comment> selectByEntity(@Param("entityId")int entityId,@Param("entityType")int entityType);
    @Select({"select  count(1) from ", TABLE_NAME,
            " where entity_id=#{entityId} and entity_type=#{entityType} and status=0"})
    int getCommentCount(@Param("entityId")int entityId,@Param("entityType")int entityType);


}