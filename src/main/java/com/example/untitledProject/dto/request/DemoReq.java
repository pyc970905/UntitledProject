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
}
