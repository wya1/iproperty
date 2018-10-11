package com.wya1.iproperty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wya1.iproperty.mapper")
public class IpropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpropertyApplication.class, args);
	}
}
