package com.example.untitledProject.controller;

import com.example.untitledProject.service.test.TestService;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@Description("웹 메인 컨트롤러")
@Log4j2
public class MainController {
    private final TestService testService;

    @Autowired
    public MainController(TestService testService) {
        this.testService = testService;
    }
    /*
    @Name           getMainPage
    @Description    메인화면 접근 컨트롤러
    @Author         박예찬
    @Date           2023.07.09
     */
    @GetMapping("/home")
    public String getMainPage(){
        return "home";
    }

    @GetMapping("/commu")
    public String getCommuPage(){
        return "commu";
    }
}
