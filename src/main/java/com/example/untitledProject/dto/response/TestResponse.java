package com.example.untitledProject.dto.response;

import com.example.untitledProject.dto.CommDto;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Description("테스트용 response객체")
public class TestResponse extends CommDto {

    @Description("테스트용 데이터 이름")
    private String nickName;

    @Description("테스트용 데이터 제목")
    private String title;

    @Description("테스트용 데이터 내용")
    private String desc;

    @Description("테스트용 데이터 에러 메세지")
    private String errMsg;
}
