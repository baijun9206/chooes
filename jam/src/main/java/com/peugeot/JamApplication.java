package com.peugeot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.peugeot.dao")
public class JamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JamApplication.class, args);
	}

}


