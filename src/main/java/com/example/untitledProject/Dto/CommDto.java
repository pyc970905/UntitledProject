package com.example.untitledProject.Dto;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Description("공통 DTO")
public class CommDto {

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
