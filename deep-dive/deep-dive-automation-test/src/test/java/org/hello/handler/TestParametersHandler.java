package org.hello.handler;

import com.thoughtworks.gauge.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestParametersHandler {

    @Step("When say hello to <field>, <field type>.")
    public void sayHello(String field, String fieldType) {
        log.info(field);
        System.out.println(fieldType);
    }
}
