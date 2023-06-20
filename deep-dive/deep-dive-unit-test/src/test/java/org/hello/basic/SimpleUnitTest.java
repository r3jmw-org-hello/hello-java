package org.hello.basic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class SimpleUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleUnitTest.class);

    @Test
    void addition() {
        logger.info(() -> "@Test - This is a Test Method");
    }

    @DisplayName("Test addition fail")
    @Test
    void addition_display_name() {
        logger.info(() -> "@DisplayName - New annotations provided by JUnit 5 to change the display name");
    }

    @Disabled("Not implemented")
    @Test
    void addition_specific() {
        // @Disabled - New annotations provided by JUnit 5 disables a test class or test method. Previously @Ignore.
    }
}
