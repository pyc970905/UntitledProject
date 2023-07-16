package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.mapper.CommuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@Description("커뮤니티 메뉴 서비스")
public class CommuServiceImpl implements CommuService {

    @Autowired
    private final CommuMapper commuMapper;
    private final static String[] fileImgExts = {".jpg", ".jpeg",".png", ".gif"};
    public CommuServiceImpl(CommuMapper commuMapper) {
        this.commuMapper = commuMapper;
    }

    @Override
    public List<CommuRes> getCommuPostsList(CommuReq commuReq) {
        List<CommuRes> result = commuMapper.selectCommuPostsList(commuReq);
        return result;
    };

    @Override
    public void postCommuContent(CommuReq commuReq, FileDto fileDto) {
        System.out.println(":::::::::::::::콘텐츠 업로드");
        if(!ObjectUtils.isEmpty(fileDto)) {
            if (Arrays.asList(fileImgExts).contains(fileDto.getFileExt())) {
                fileDto.setFileDivCd("0");
            } else {
                fileDto.setFileDivCd("1");
            }
            commuMapper.insertCommuFile(fileDto);
            CommuRes commuFileNo = commuMapper.selectFileNo(commuReq);
            commuReq.setFileNo(commuFileNo.getFileNo());
            commuReq.setFileUuid(fileDto.getFileUuid());
            commuMapper.insertCommuContent(commuReq);
        } else {
            commuMapper.insertCommuContent(commuReq);
        }
    };

    @Override
    public CommuRes getCommuPostOne(CommuReq commuReq) {

        commuMapper.updateCommContentViews(commuReq);
        CommuRes result = commuMapper.selectCommuPostOne(commuReq);

        return result;
    };
}
