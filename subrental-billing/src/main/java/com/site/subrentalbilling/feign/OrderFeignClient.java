package com.site.subrentalbilling.feign;

import com.site.subrentalbilling.feign.fallback.OrderFeignFallback;
import com.site.subrentalcore.feignResponse.OrderFeignResponse;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "subrental-order", path = "/api/orders", fallback = OrderFeignFallback.class)
public interface OrderFeignClient {

    @GetMapping("/billing/documents")
    @Bulkhead(name = "subrental-billing")
    List<OrderFeignResponse> billingDocuments(@RequestParam("contractDate") String contractDate);

    @GetMapping("/fail")
    String fail(@RequestParam("contractDate") String contractDate);
}
