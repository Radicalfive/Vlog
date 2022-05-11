package com.mqxu.vlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mqxu
 */
@SpringBootApplication
@MapperScan("com.mqxu.vlog.mapper")
public class VlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlogApiApplication.class, args);
    }

}
