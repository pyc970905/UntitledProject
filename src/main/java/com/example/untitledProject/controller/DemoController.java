package com.example.untitledProject.controller;

import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
@Description("데모 메뉴 컨트롤러")
@Log4j2
public class DemoController {
}
