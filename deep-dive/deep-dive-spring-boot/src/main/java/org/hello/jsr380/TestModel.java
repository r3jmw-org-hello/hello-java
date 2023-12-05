package org.hello.jsr380;

import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

public record TestModel(
        @NotNull(groups = Create.class)
        Long createId,
        @NotNull(groups = Update.class)
        Long updateId,
        @NotNull(groups = Delete.class)
        Long deleteId,
        @NotNull(groups = All.class)
        Long allId,
        @NotBlank
        String name,
        @Valid
        @NotNull
        TestSubModel testSubModel
) {
        public interface Create{}

        public interface Update{}

        public interface Delete{}

        @GroupSequence({Default.class, Create.class, Update.class, Delete.class})
        public interface All{}
}
