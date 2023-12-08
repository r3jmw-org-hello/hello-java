package org.hello.jsr380;

import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
class TestRecordValidator {

    record TestRecord(
            @NonNull
            Object metadata,
            @NotNull
            String message,
            @Valid
            TestRecord testRecord
    ) {}

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Test
    void testRecordValidator() {
        Validator validator = factory.getValidator();

        TestRecord test = new TestRecord(null, null, new TestRecord(null, null, null));
        Set<ConstraintViolation<TestRecord>> violations = validator.validate(test);
        for(ConstraintViolation<TestRecord> violation: violations) {
            log.info(violation.toString());
            log.info(violation.getMessage());
        }

        Assertions.assertEquals(true, true);
    }

    void testCollection(List<@Valid TestRecord> tests) {

    }
}
