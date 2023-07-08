package com.example.untitledProject.mapper;

import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.TestResponse;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface TestMapper {
    List<TestResponse> testSelect(TestRequest testRequest);
}