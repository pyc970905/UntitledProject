package com.example.untitledProject.Dto.Request;

import com.example.untitledProject.Dto.CommDto;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Description("테스트용 request객체")
public class TestRequest extends CommDto {

    @Description("테스트용 데이터 이름")
    private String nickName;

    @Description("테스트용 데이터 제목")
    private String title;

    @Description("테스트용 데이터 내용")
    private String desc;
}
