package com.example.untitledProject.service;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;
import com.example.untitledProject.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestMapper testMapper;

    @Autowired
    public TestServiceImpl(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public List<TestResponse> testSelect(TestRequest testRequest) {
        List<TestResponse> testResponse = new ArrayList<>();
        try {
            System.out.println("Mapper 호출 시작");
            testResponse = testMapper.testSelect(testRequest);
            System.out.println("Mapper 호출 종료");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return testResponse;
    }
}