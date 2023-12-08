package org.hello.jsr380;

import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;

public class TestRecordValidator {

    record TestRecord(
            Object metadata,
            @NotNull
            String message,
            @Valid
            TestRecord testRecord
    ) {}

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
}
