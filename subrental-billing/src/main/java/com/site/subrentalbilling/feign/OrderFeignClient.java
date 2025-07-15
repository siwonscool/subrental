package com.site.subrentalbilling.feign;

import com.site.subrentalcore.feignResponse.OrderFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "subrental-order", path = "/api/orders")
public interface OrderFeignClient {
    @GetMapping("/billing/documents")
    List<OrderFeignResponse> billingDocuments(@RequestParam("contractDate") String contractDate);
}
