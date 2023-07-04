package org.hello.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/test-auth")
    @ResponseBody
    @PreAuthorize("hasPermission('ADMIN') or hasPermission('TEST_PERMISSION')")
    public String testAuth() {
        return "test";
    }

    @GetMapping("/test-exception")
    @ResponseBody
    public String testException() throws IllegalAccessException {
        throw new IllegalAccessException("Forbidden");
    }
}
