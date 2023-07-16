package com.example.untitledProject.mapper;

import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.request.TestRequest;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.dto.response.TestResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommuMapper {
    List<CommuRes> selectCommuPostsList(CommuReq commuReq);

    void insertCommuContent(CommuReq commuReq);

    void updateCommContentViews(CommuReq commuReq);
    CommuRes selectCommuPostOne(CommuReq commuReq);
    CommuRes selectFileNo(CommuReq commuReq);
    void insertCommuFile(FileDto fileDto);

}
