package org.hello.jsr380.model;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

public record RequestTemplate(
//        @NotNull(groups = {Update.class, Default.class})
        Long requestId,
//        @NotEmpty(groups = {Creation.class, Update.class, RequestTitle.class})
        @NotEmpty
        String requestTitle
) {
    public interface RequestTitle{}

    public interface Creation{}

    @GroupSequence(value = {Default.class, RequestTitle.class})
    public interface Update{}
}
