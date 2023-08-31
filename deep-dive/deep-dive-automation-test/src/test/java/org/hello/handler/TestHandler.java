package org.hello.handler;

import com.thoughtworks.gauge.Step;

import java.util.concurrent.TimeUnit;

public class TestHandler {

    @Step("When given message for terminal to display")
    public void printMessage() throws InterruptedException {
        System.out.println("message");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("end");
    }
}
