package com.example.untitledProject.dto.response;

import com.example.untitledProject.dto.CommDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Description;

@Getter
@Setter
@ToString
@Description("커뮤니티 화면 응답 VO")
public class CommuRes extends CommDto {

    private Integer _id;

    private String writer;

    private String title;

    private String content;

    private String errMsg;
}
