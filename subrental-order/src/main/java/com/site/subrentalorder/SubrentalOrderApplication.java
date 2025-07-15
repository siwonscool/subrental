package com.site.subrentalorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubrentalOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubrentalOrderApplication.class, args);
    }

}
