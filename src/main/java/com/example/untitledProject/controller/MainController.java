package com.example.untitledProject.controller;

import com.example.untitledProject.Utils.ClientUtils;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.dto.response.DemoRes;
import com.example.untitledProject.service.CommuService;
import com.example.untitledProject.service.DemoService;
import com.example.untitledProject.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
@Description("웹 메인 컨트롤러")
@Log4j2
public class MainController {
    private final CommuService commuService;
    private final DemoService demoService;
    private final HomeService homeService;

    @Autowired
    public MainController(CommuService commuService, DemoService demoService, HomeService homeService) {
        this.commuService = commuService;
        this.demoService = demoService;
        this.homeService = homeService;
    }

    /*
    @Name           getMainPage
    @Description    메인화면 접근 컨트롤러
    @Author         박예찬
    @Date           2023.07.09
     */
    @GetMapping("/")
    public String getMainPage(){
        return "main";
    }
    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/commu")
    public String getCommuPage(Model model){
        List<CommuRes> commuPostsList = commuService.getCommuPostsList(null);
        model.addAttribute("commuPostsList", commuPostsList);
        return "commu";
    }

    @GetMapping("/demo")
    public String getDemoPage(Model model){
        List<DemoRes> demoPostsList = demoService.getDemoPostsList(null);
        model.addAttribute("demoPostsList", demoPostsList);
        return "demo";
    }
}
