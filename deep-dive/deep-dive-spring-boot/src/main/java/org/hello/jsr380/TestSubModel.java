package org.hello.jsr380;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TestSubModel(
        @NotNull
        Long subId,
        @NotEmpty
        String subName
) {
}
