package com.example.untitledProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.untitledProject.mapper")
public class UntitledProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UntitledProjectApplication.class, args);
	}


}
