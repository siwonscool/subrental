package com.site.billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {
    @GetMapping("/")
    public String index() {
        return "billing";
    }
}
