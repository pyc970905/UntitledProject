package com.example.untitledProject.service;

import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.mapper.CommuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Description("커뮤니티 메뉴 서비스")
public class CommuServiceImpl implements CommuService {

    @Autowired
    private final CommuMapper commuMapper;

    public CommuServiceImpl(CommuMapper commuMapper) {
        this.commuMapper = commuMapper;
    }

    @Override
    public List<CommuRes> getCommuPostsList(CommuReq commuReq) {
        List<CommuRes> result = commuMapper.selectCommuPostsList(commuReq);
        return result;
    };

    @Override
    public void postCommuContent(CommuReq commuReq) {
        commuMapper.insertCommuContent(commuReq);
    };

    @Override
    public CommuRes getCommuPostOne(CommuReq commuReq) {

        commuMapper.updateCommContentViews(commuReq);
        CommuRes result = commuMapper.selectCommuPostOne(commuReq);

        return result;
    };
}
