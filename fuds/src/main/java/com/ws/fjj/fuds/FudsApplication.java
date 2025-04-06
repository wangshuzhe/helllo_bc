package com.ws.fjj.fuds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ws.fjj.fuds.dao")
public class FudsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FudsApplication.class, args);
    }

}
