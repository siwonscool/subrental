package com.site.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;

@Component
@Slf4j
public class GlobalAuthFilter extends AbstractGatewayFilterFactory<GlobalAuthFilter.Config> {

    private final List<String> excludeUris = List.of("/api/**");

    public GlobalAuthFilter() {
        super(Config.class);
    }

    public static class Config {

    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            final ServerHttpRequest request = exchange.getRequest();
            final String path = request.getURI().getPath();

            for (String excludeUri : excludeUris) {
                if (excludeUri.equals(path)) {
                    return chain.filter(exchange);
                }
            }

            log.info("=== api gateway filter start ===");

            final MultiValueMap<String, HttpCookie> cookies = request.getCookies();

            if (cookies.isEmpty() || !cookies.containsKey("SessionKey")) {
                log.warn("Session Key Not Exists");
                //return failAuthenticationResponse(exchange);
                return chain.filter(exchange);
            }

            final HttpCookie httpCookie = cookies.get("SessionKey").get(0);
            final String sessionCookie = httpCookie.getValue();

            // TODO redis 인증키 조회

            return chain.filter(exchange);
        };
    }

    private Mono<Void> failAuthenticationResponse(ServerWebExchange exchange) {
        final ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
