package com.example.untitledProject.controller.test;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;
import com.example.untitledProject.service.test.TestService;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
@Description("웹 메인 컨트롤러")
@Log4j2
public class TestController {
    private final TestService testService;
    @Autowired
    public TestController(TestService testService) {
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

            if(testResponse.getNickName().equals("") && StringUtils.isEmpty(testResponse.getNickName())) {
                System.out.println("is it true????");
                model.addAttribute("testResponse", testResponse);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }

        return "test";
    }

    @PostMapping("/members/search")
    public String searchMembers(Model model) {
        TestRequest testRequest = new TestRequest();
        List<TestResponse> result = new ArrayList<TestResponse>();
        result= testService.testSelect(testRequest);

        model.addAttribute("members", result);

        return "member-list";
    }

    @PostMapping("/test/insert2")
    public ResponseEntity<TestResponse> testInsert (@RequestBody TestRequest testRequest) {

        TestResponse testResponse = new TestResponse();
        testRequest.setNickName("방국봉");
        System.out.println(testRequest.toString());
        testService.testInsert(testRequest);

        return new ResponseEntity<TestResponse>(HttpStatusCode.valueOf(200));
    }
}
