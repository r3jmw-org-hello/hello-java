package org.hello.api.controller.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "TestAdditionRequest", description = "The model for test addition request")
public record TestAdditionRequestV2(
        Long additionId,
        String testAddition
) {
}
