package org.hello.api.controller.external;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @Deprecated(since = "release-1.2.0", forRemoval = true)
    @ResponseStatus(code = HttpStatus.OK, reason = "Test Success")
    public String test() { //
        return "test";
    }
}
