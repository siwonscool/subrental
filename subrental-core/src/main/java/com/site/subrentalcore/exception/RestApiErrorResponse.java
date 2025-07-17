package com.site.subrentalcore.exception;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
public class RestApiErrorResponse {
    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final int status;
    private final String errorType;
    private final String errorCode;
    private String description;

    @Builder
    private RestApiErrorResponse(int status, String errorType, String errorCode,
                          String description) {
        this.status = status;
        this.errorType = errorType;
        this.errorCode = errorCode;
        this.description = description;
    }

    public static ResponseEntity<RestApiErrorResponse> toResponseEntity(RuntimeException e) {
        ErrorCode errorCode = ErrorCode.INTER_SERVER_ERROR;
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(RestApiErrorResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .errorType(errorCode.getHttpStatus().name())
                        .errorCode(errorCode.name())
                        .description(e.getMessage())
                        .build());
    }
}
