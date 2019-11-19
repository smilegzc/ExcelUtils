package com.smile.excelutils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smile.excelutils.mapper")
public class ExcelUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelUtilsApplication.class, args);
    }

}
