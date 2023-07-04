package com.example.untitledProject.Controller;

import com.example.untitledProject.Dto.Request.TestRequest;
import com.example.untitledProject.Dto.Response.TestResponse;
import com.example.untitledProject.Service.TestService;
import jdk.jfr.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@Description("웹 메인 컨트롤러")
public class MainController {
    private final TestService testService;
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
        } finally {
            System.out.println("No Error");
            return "test";
        }
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
            testResponse = testService.getMyName(testRequest);
            model.addAttribute( "testResponse", testResponse);
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            return "test";
        }
    }


}
