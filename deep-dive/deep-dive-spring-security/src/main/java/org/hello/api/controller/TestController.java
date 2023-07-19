package org.hello.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * @deprecated Test deprecated annotation
     */
    @GetMapping("/test")
    @ResponseBody
    @Deprecated(since = "release-1.2.0", forRemoval = true)
    public String test() { //
        return "test";
    }

    @GetMapping(value = "/test", headers = { "X-API-VERSION=v2" })
    public ResponseEntity<String> testV2() {
        return ResponseEntity.ok().body("v2");
    }

    @GetMapping("/test?version=1.3.0")
    public String testV3(
            @RequestParam(value = "version", required = true) String version
    ) {
        return "v3";
    }

    @GetMapping(value = "/test", params = "version=1.3.0")
    public String testV4(
            @RequestParam(value = "version", required = true) String version
    ) {
        return "v4";
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
