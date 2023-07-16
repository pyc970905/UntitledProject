package com.example.untitledProject.controller;

import com.example.untitledProject.Utils.ClientUtils;
import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.DemoReq;
import com.example.untitledProject.dto.response.DemoRes;
import com.example.untitledProject.service.DemoService;
import com.example.untitledProject.service.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/demo")
@Description("데모 메뉴 컨트롤러")
@Log4j2
public class DemoController {

    private final DemoService DemoService;
    private final FileUploadService fileUploadService;
    @Autowired
    public DemoController(DemoService DemoService, FileUploadService fileUploadService) {
        this.DemoService = DemoService;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/post")
    public String getPostingDemoForm(Model model){
        return "postingDemoForm";
    }

    @PostMapping("/post")
    public String postDemoContent(DemoReq demoReq, @RequestParam("DemoFile") MultipartFile multipartFile, HttpServletRequest httpRequest) {

        if(multipartFile.getSize() > 0) {

            FileDto fileDto = fileUploadService.storeFile(multipartFile);
            System.out.println("::::::::::::::::"+fileDto.toString());
            //수정해야할곳
            fileDto.setFileUrl("/Users/parkyechan/Desktop/untitledProject/src/main/resources/static/file/" + fileDto.getFileUuid() + fileDto.getFileExt());
            fileDto.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            fileDto.setRgstId("Test2");

            //ip세팅
            demoReq.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            //test데이터 로그인 기능 추가되면 삭제해야함
            demoReq.setRgstId("Test2");
            demoReq.setFileUuid(fileDto.getFileUuid());
            DemoService.postDemoContent(demoReq, fileDto);
        } else {
            demoReq.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            //test데이터 로그인 기능 추가되면 삭제해야함
            demoReq.setRgstId("Test2");
            DemoService.postDemoContent(demoReq, null);
        }


        return  "redirect:/demo";
    }


//    @GetMapping("/content/download/{demoNo}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String demoNo, DemoReq DemoReq) throws IOException {
//        DemoReq.setDemoNo(demoNo);
//        DemoRes result = DemoService.getDemoPostOne(DemoReq);
//        // 파일 경로를 설정하고 실제 파일을 읽어온다
//        Path filePath = Paths.get(result.getFileUrl());
//        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
//
//        // 다운로드 응답을 생성한다
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filePath.getFileName() + "\"")
//                .body(resource);
//    }
}
