package com.example.toutiao.mapper;

import com.example.toutiao.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> findAll();
}
