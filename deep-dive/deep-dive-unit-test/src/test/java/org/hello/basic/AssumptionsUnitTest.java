package org.hello.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionsUnitTest {

    @Test
    void trueAssumption() {
        assumeTrue(true);
        assertEquals(true, 5 > 1);
    }

    @Test
    void falseAssumption() {
        assumeTrue(false);
        assertEquals(true, 5 > 1);
    }

    @Test
    void assumptionThat() {
        assumingThat(() -> 1 == 2, () -> assertEquals(true, 5 > 1));
    }
}
