package com.site.subrentalbilling.feign.fallback;

import com.site.subrentalbilling.feign.OrderFeignClient;
import com.site.subrentalcore.feignResponse.OrderFeignResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFeignFallback implements OrderFeignClient {
    @Override
    public List<OrderFeignResponse> billingDocuments(String contractDate) {
        return List.of(OrderFeignResponse.builder()
                .orderNumber("0")
                .id(-1L).build());
    }

    @Override
    public String fail(String contractDate) {
        return "fail fallback called";
    }
}
