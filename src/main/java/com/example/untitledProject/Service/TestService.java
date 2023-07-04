package com.example.untitledProject.Service;

import com.example.untitledProject.Dto.Request.TestRequest;
import com.example.untitledProject.Dto.Response.TestResponse;

public interface TestService {

    public TestResponse getMyName(TestRequest testRequest);
}
