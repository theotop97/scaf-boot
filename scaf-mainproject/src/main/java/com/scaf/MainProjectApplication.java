package com.scaf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan("com.scaf.mapper")
public class MainProjectApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainProjectApplication.class, args);
    }
}