package com.site.subrentalcore.feignResponse;

import lombok.Builder;

@Builder
public record OrderFeignResponse(Long id, String orderNumber) {
}
