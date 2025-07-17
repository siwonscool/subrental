package com.site.subrentalbilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.site.subrentalcore","com.site.subrentalbilling"})
@EnableDiscoveryClient
@EnableFeignClients
public class SubrentalBillingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubrentalBillingApplication.class, args);
    }
}
