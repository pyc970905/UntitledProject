package com.example.untitledProject.dto.request;

import com.example.untitledProject.dto.CommDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Description;

@Getter
@Setter
@ToString
@Description("데모 화면 요청 VO")
public class DemoReq extends CommDto {

    @jdk.jfr.Description("게시글 작성")
    private String writer;

    @jdk.jfr.Description("게시글 제목")
    private String title;

    @jdk.jfr.Description("게시글 내용")
    private String content;

    @jdk.jfr.Description("게시글 내용")
    private String demoNo;

    private String fileUuid;

    private String fileNo;

    private String fileDivCd;
}
