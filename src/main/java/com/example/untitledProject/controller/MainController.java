package com.example.untitledProject.controller;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;
import com.example.untitledProject.service.TestService;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
    @Name           getTestYn
    @Description    테스트용 API
    @Author         박예찬
    @Date           2023.07.04
     */
    @GetMapping("/test")
    public String getTestYn() {
        try {
            System.out.println("Start");
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println("No Error");
        return "test";

    }

    /*
    @Name           getMyName
    @Description    테스트용 API
    @Author         박예찬
    @Date           2023.07.04
     */
    @GetMapping("/test2")
    public String getMyName(Model model) {

        TestResponse testResponse = new TestResponse();
        TestRequest testRequest = new TestRequest();

        try {
            testRequest.setNickName("박예찬");
            testResponse = testService.testSelect(testRequest).get(0);
            System.out.println(testResponse.toString());

            if(testResponse.getNickName().equals("") && testResponse.getNickName() != null) {
                System.out.println("is it true????");
                model.addAttribute("testResponse", testResponse);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(":::::::::::::::::::::::::::");
            System.out.println(testResponse.toString());
            System.out.println(":::::::::::::::::::::::::::");
            System.out.println("Error");
        }

        return "test";
    }

    @PostMapping("/members/search")
    public String searchMembers(Model model) {
    	List<TestRequest> findMembers = new ArrayList<TestRequest>();
        for(int i= 0; i <5; i++) {
            TestRequest testRequest = new TestRequest();
            testRequest.setNickName("박예찬"+ i);
            findMembers.add(testRequest);
            log.info(findMembers);
        }
        model.addAttribute("members", findMembers);

        return "member-list";
    }
}
