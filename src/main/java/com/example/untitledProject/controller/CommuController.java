package com.example.untitledProject.controller;

import com.example.untitledProject.Utils.ClientUtils;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.service.CommuService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commu")
@Description("커뮤니티 메뉴 컨트롤러")
@Log4j2
public class CommuController {
    private final CommuService commuService;
    @Autowired
    public CommuController(CommuService commuService) {
        this.commuService = commuService;
    }

    @GetMapping("/post")
    public String getPostingCommuForm(Model model){
        return "postingCommuForm";
    }

    @PostMapping("/post")
    public ResponseEntity<String> postCommuContent(CommuReq commuReq, HttpServletRequest httpRequest) {

        commuReq.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
        commuReq.setRgstId("Test2");

        commuService.postCommuContent(commuReq);
        return  new ResponseEntity<String>(HttpStatusCode.valueOf(200));
    }
}
