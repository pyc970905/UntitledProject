package com.example.untitledProject.Service;

import com.example.untitledProject.Dto.Request.TestRequest;
import com.example.untitledProject.Dto.Response.TestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @Override
    public TestResponse getMyName(TestRequest testRequest){
        TestResponse testResponse = new TestResponse();

        try {
            if(testRequest.getNickName().equals("박예찬")) testResponse.setNickName("BAGUETTECHAN");
        } catch ( NullPointerException e) {
            System.out.println(e.getMessage());
            testResponse.setErrMsg(e.getMessage());
        } finally {
            return testResponse;
        }
    }
}
