package com.site.subrentalbilling.service;

import com.site.subrentalbilling.feign.OrderFeignClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingService {

    private final OrderFeignClient orderFeignClient;

    public String getBillingDocument(){
        log.info("getBillingDocument called on thread: {}", Thread.currentThread().getId());
        return orderFeignClient.billingDocuments("2025-01-01").toString();
    }

    public String fail(){
        return orderFeignClient.fail(null);
    }
}
