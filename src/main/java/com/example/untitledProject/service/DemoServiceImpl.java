package com.example.untitledProject.service;

import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.DemoReq;
import com.example.untitledProject.dto.response.DemoRes;
import com.example.untitledProject.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@Description("데모 업로드 메뉴 서비스")
public class DemoServiceImpl implements DemoService{
    @Autowired
    private final DemoMapper DemoMapper;
    private final static String[] fileImgExts = {".jpg", ".jpeg",".png", ".gif"};
    public DemoServiceImpl(DemoMapper DemoMapper) {
        this.DemoMapper = DemoMapper;
    }

    @Override
    public List<DemoRes> getDemoPostsList(DemoReq DemoReq) {
        List<DemoRes> result = DemoMapper.selectDemoPostsList(DemoReq);
        return result;
    };

    @Override
    public void postDemoContent(DemoReq DemoReq, FileDto fileDto) {
        System.out.println(":::::::::::::::콘텐츠 업로드");
        if(!ObjectUtils.isEmpty(fileDto)) {
            if (Arrays.asList(fileImgExts).contains(fileDto.getFileExt())) {
                fileDto.setFileDivCd("0");
            } else {
                fileDto.setFileDivCd("1");
            }
            DemoMapper.insertDemoFile(fileDto);
            DemoRes DemoFileNo = DemoMapper.selectFileNo(DemoReq);
            DemoReq.setFileNo(DemoFileNo.getFileNo());
            DemoReq.setFileUuid(fileDto.getFileUuid());
            DemoMapper.insertDemoContent(DemoReq);
        } else {
            DemoMapper.insertDemoContent(DemoReq);
        }
    };

    @Override
    public DemoRes getDemoPostOne(DemoReq DemoReq) {

        DemoMapper.updateCommContentViews(DemoReq);
        DemoRes result = DemoMapper.selectDemoPostOne(DemoReq);

        return result;
    };
}
