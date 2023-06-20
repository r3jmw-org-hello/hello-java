package org.hello.basic;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class LifecycleMethodsUnitTest {

    private final static Logger logger = LoggerFactory.getLogger(LifecycleMethodsUnitTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info(() -> "@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void beforeEach() {
        logger.info(() -> "@BeforeEach - executes before each test methods in this class");
    }

    @AfterAll
    static void afterAll() {
        logger.info(() -> "@AfterAll - executes once after all test methods in this class");
    }

    @AfterEach
    void afterEach() {
        logger.info(() -> "@AfterEach - executes after each test methods in this class");
    }

    @DisplayName("test 1")
    @Test
    void test1() {
        Assertions.assertTrue(true, "test 1 pass");
    }

    @DisplayName("test 2")
    @Test
    void test2() {
        Assertions.assertTrue(true, "test 2 pass");
    }
}
