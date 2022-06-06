package com.example.controller;

import com.example.entity.Student;
import com.sun.deploy.net.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        //这里就用Session代替ID吧
        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次登陆界面");
        return "login";
    }
    @RequestMapping("/student")
    @ResponseBody
    public Student student(){
        Student student = new Student();
        student.setName("小明");
        student.setSex("男");
        student.setSid(10);
        return student;
    }
}
