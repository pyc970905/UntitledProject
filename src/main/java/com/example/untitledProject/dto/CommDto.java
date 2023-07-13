package com.example.untitledProject.dto;

import jdk.jfr.Description;
import lombok.Data;

@Data
@Description("공통 DTO")
public class CommDto {
    @Description("pk")
    private Long _id;

    @Description("등록자ID")
    private String rgstId;

    @Description("등록자IP")
    private String rgstIp;

    @Description("등록일자")
    private String rgstDtm;

    @Description("등록자ID")
    private String chgId;

    @Description("등록자IP")
    private String chgIp;

    @Description("등록자ID")
    private String chgrgstDtm;
}
