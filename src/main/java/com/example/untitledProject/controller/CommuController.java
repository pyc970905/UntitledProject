package com.example.untitledProject.controller;

import com.example.untitledProject.Utils.ClientUtils;
import com.example.untitledProject.dto.FileDto;
import com.example.untitledProject.dto.request.CommuReq;
import com.example.untitledProject.dto.response.CommuRes;
import com.example.untitledProject.service.CommuService;
import com.example.untitledProject.service.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/commu")
@Description("커뮤니티 메뉴 컨트롤러")
@Log4j2
public class CommuController {
    private final CommuService commuService;
    private final FileUploadService fileUploadService;
    @Autowired
    public CommuController(CommuService commuService, FileUploadService fileUploadService) {
        this.commuService = commuService;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/post")
    public String getPostingCommuForm(Model model){
        return "postingCommuForm";
    }

    @PostMapping("/post")
    public String postCommuContent(CommuReq commuReq, @RequestParam("commuFile") MultipartFile multipartFile, HttpServletRequest httpRequest) {

        if(multipartFile.getSize() > 0) {

            FileDto fileDto = fileUploadService.storeFile(multipartFile);
            System.out.println("::::::::::::::::"+fileDto.toString());
            //수정해야할곳
            fileDto.setFileUrl("/Users/parkyechan/Desktop/untitledProject/src/main/resources/static/file/" + fileDto.getFileUuid() + fileDto.getFileExt());
            fileDto.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            fileDto.setRgstId("Test2");

            //ip세팅
            commuReq.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            //test데이터 로그인 기능 추가되면 삭제해야함
            commuReq.setRgstId("Test2");
            commuReq.setFileUuid(fileDto.getFileUuid());
            commuService.postCommuContent(commuReq, fileDto);
        } else {
            commuReq.setRgstIp(ClientUtils.getRemoteIP(httpRequest));
            //test데이터 로그인 기능 추가되면 삭제해야함
            commuReq.setRgstId("Test2");
            commuService.postCommuContent(commuReq, null);
        }


        return  "redirect:/commu";
    }

    @GetMapping("/content/{commNo}")
    public String getCommContentDtl(@PathVariable String commNo, CommuReq commuReq , Model model, HttpServletRequest httpRequest) {
        commuReq.setCommNo(commNo);
        CommuRes result = commuService.getCommuPostOne(commuReq);

        model.addAttribute("commContent", result);
        return  "commuContent";
    }

    @GetMapping("/content/download/{commNo}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String commNo, CommuReq commuReq) throws IOException {
        commuReq.setCommNo(commNo);
        CommuRes result = commuService.getCommuPostOne(commuReq);
        // 파일 경로를 설정하고 실제 파일을 읽어온다
        Path filePath = Paths.get(result.getFileUrl());
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));

        // 다운로드 응답을 생성한다
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filePath.getFileName() + "\"")
                .body(resource);
    }
}

