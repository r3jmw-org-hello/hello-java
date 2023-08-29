package org.hello.api.controller.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "TestRequest", description = "The model for test request")
public record TestRequestV2(
        Long id,
        String test,
        TestAdditionRequestV2 testAdditionRequest,
        String transactionId
) {}
