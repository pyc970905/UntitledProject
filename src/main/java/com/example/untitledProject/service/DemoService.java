package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.DemoReq;
import com.example.untitledProject.dto.response.DemoRes;

import java.util.List;

public interface DemoService {
    public List<DemoRes> getDemoPostsList(DemoReq DemoReq);

    public void postDemoContent(DemoReq DemoReq, FileDto fileDto);
    public DemoRes getDemoPostOne(DemoReq DemoReq);
}
