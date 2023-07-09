package com.example.untitledProject.service.test;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;

import java.util.List;

public interface TestService {
    public List<TestResponse> testSelect(TestRequest testRequest);
    public void testInsert(TestRequest testRequest);
}
