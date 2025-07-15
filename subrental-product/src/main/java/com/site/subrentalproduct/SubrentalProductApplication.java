package com.site.subrentalproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubrentalProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubrentalProductApplication.class, args);
    }

}
