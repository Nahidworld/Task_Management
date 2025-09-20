package com.nahid.tasks.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ErrorResponse", description = "Schema to hold error response information")
public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
