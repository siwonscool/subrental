package com.site.subrentalbilling.controller;

import com.site.subrentalbilling.service.BillingService;
import com.site.subrentalcore.exception.ErrorCode;
import com.site.subrentalcore.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/billings")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @GetMapping
    public String billing() {
        return billingService.getBillingDocument();
    }

    @GetMapping("/fail")
    public String fail() {
        return billingService.fail();
    }

    @GetMapping("/fail2")
    public void fail2() {throw new RestApiException(ErrorCode.INTER_SERVER_ERROR);}

    @GetMapping("/test-bulkhead")
    public String testBulkhead() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream.range(0, 10).forEach(i -> executor.submit(() -> {
            try {
                String result = billingService.getBillingDocument();
                System.out.println("Thread " + i + ": " + result);
            } catch (Exception e) {
                System.out.println("Thread " + i + ": exception = " + e.getMessage());
            }
        }));

        executor.shutdown();
        return "Bulkhead test started";
    }
}
