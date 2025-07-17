package com.site.subrentalorder.controller;

import com.site.subrentalcore.feignResponse.OrderFeignResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/billing/documents")
    public List<OrderFeignResponse> billingDocuments(@RequestParam("contractDate") String contractDate) {
        log.info("get target when Order is contract date: {}", contractDate);
        OrderFeignResponse response = OrderFeignResponse.builder()
                .id(1L)
                .orderNumber("SDE000000003")
                .build();

        return List.of(response, response, response, response, response);
    }

    @GetMapping("/fail")
    public String fail(@RequestParam("contractDate") String contractDate) {
        if (contractDate == null || contractDate.isEmpty()) {
            throw new RuntimeException();
        }

        return contractDate;
    }
}
