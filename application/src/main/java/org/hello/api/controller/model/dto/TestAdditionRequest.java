package org.hello.api.controller.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The model for test request", deprecated = true)
@Deprecated(since = "v1.0", forRemoval = true)
public record TestAdditionRequest(
        Long additionId,
        String testAddition
) {}
