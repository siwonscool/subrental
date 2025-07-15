package com.site.subrentalbilling.service;

import com.site.subrentalbilling.feign.OrderFeignClient;
import com.site.subrentalcore.feignResponse.OrderFeignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final OrderFeignClient orderFeignClient;

    public String writeBillingDocument(){
        List<OrderFeignResponse> responses = orderFeignClient.billingDocuments("2025-01-01");
        return responses.toString();
    }
}
