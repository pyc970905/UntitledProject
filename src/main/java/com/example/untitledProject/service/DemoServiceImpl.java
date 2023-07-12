package com.example.untitledProject.service;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Description("데모 업로드 메뉴 서비스")
public class DemoServiceImpl implements DemoService{
}
