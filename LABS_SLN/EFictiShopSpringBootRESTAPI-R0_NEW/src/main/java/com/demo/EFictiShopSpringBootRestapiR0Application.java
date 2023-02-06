package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

//@ComponentScan
//@EnableAutoConfiguration
//@Configuration
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EFictiShopSpringBootRestapiR0Application { public static void main(String[] args) {
    System.out.println("Standalone core java App!");
        SpringApplication.run(EFictiShopSpringBootRestapiR0Application.class, args);
    }
}

