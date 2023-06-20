package org.hello.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionUnitTest {

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not Supported");
        });
        assertEquals("Not Supported", exception.getMessage());
    }

    @Test
    void assertThrowException() {
        assertThrows(IllegalArgumentException.class, () ->  Integer.valueOf(null));
    }
}
