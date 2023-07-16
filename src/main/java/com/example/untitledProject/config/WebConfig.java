package com.example.untitledProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/file/**")
                .addResourceLocations("file:/Users/parkyechan/Desktop/untitledProject/src/main/resources/static/file/")
                .setCachePeriod(3600) // 캐시 기간 설정 (초 단위)
                .resourceChain(true);
    }
}