package org.hello.api.controller;

import org.hello.api.controller.model.dto.TestRequest;
import org.hello.api.controller.model.dto.TestRequestV2;
import org.hello.api.controller.model.vo.TestResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * @deprecated business changes
     */
    @PostMapping()
    @ResponseBody
    @Deprecated(since = "v1.0", forRemoval = true)
    public TestResult test(@RequestBody() TestRequest testRequest) {
        return new TestResult();
    }

    @PostMapping("/v2")
    @ResponseBody
    public TestResult testV2(@RequestBody() TestRequestV2 testRequest) {
        return new TestResult();
    }
}
