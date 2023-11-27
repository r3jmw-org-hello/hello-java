package org.hello;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestModel {

    @Builder.Default()
    private Long testExpression = 2L;
}
