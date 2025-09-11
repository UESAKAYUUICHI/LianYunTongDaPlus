package main.lianyuntongdaplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("main.lianyuntongdaplus.module.basicdata.mapper")
public class LianYunTongDaPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LianYunTongDaPlusApplication.class, args);
    }

}