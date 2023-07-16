package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.dto.response.TestResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommuService {
    public List<CommuRes> getCommuPostsList(CommuReq commuReq);

    public void postCommuContent(CommuReq commuReq, FileDto fileDto);
    public CommuRes getCommuPostOne(CommuReq commuReq);

}
