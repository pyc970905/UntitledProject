package com.example.untitledProject.service;

import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.dto.response.TestResponse;

import java.util.List;

public interface CommuService {
    public List<CommuRes> getCommuPostsList(CommuReq commuReq);

    public void postCommuContent(CommuReq commuReq);
    public CommuRes getCommuPostOne(CommuReq commuReq);

}
