package com.example.untitledProject.service.test;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;
import com.example.untitledProject.mapper.TestMapper;
import com.example.untitledProject.service.test.TestService;
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
            testResponse = testMapper.testSelect(testRequest);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return testResponse;
    }
    @Override
    public void testInsert(TestRequest testRequest) {
        List<TestResponse> testResponse = new ArrayList<>();
        try {
            testMapper.testInsert(testRequest);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

}