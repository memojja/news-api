package com.newsapi.bundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BundleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BundleApplication.class, args);
    }

}
