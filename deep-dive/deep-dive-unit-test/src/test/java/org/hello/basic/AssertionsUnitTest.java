package org.hello.basic;

import
        org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsUnitTest {

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(5 < numbers.stream()
                .mapToInt(Integer::intValue)
                .sum(), () -> "Sum should be greater than 5"
        );
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(1, numbers[1]),
                () -> assertEquals(3, numbers[3]),
                () -> assertEquals(4, numbers[4])
        );
    }
}
