package com.github.wz2cool.mybatisdynamicquerydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.github.wz2cool.mybatisdynamicquerydemo.mapper.*")
@EnableSwagger2
public class MybatisDynamicQueryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicQueryDemoApplication.class, args);
    }

}
