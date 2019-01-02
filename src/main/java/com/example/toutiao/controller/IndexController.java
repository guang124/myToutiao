package com.example.toutiao.controller;

import com.example.toutiao.mapper.StudentMapper;
import com.example.toutiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stuTest")
public class indexController {
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(path = {"/","/index"})
    @ResponseBody
    public String index() {
        return "hello";
    }
    @RequestMapping("/vm")
    public ModelAndView news(ModelAndView model) {
        model.setViewName("news");
        model.addObject("now","2019-01-01");
        return model;
    }
    @RequestMapping(value = "/login")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        List<String> userList=new ArrayList<>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");

        modelAndView.addObject("userList", userList);
        return modelAndView;
    }


    @RequestMapping("/listStudent")
    public ModelAndView listStudent(ModelAndView modelAndView){
        modelAndView.setViewName("listStudent");

        List<Student> userList=new ArrayList<>();
        userList=studentMapper.findAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
}
