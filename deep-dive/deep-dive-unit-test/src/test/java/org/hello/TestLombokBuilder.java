package org.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestLombokBuilder {


    @Test
    void testBuilderDeafult() {
        TestModel testModel = new TestModel();
        TestModel testModelBuilder = TestModel.builder().build();

        Assertions.assertEquals(testModel.getTestExpression(), testModelBuilder.getTestExpression());
    }

    @Test
    void testFloat() {
        double f = Double.parseDouble("1231312.12");
        System.out.println(f);
        Assertions.assertEquals(f, 1231312.12);
    }
}
