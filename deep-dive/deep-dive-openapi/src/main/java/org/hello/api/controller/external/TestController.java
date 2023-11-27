package org.hello.api.controller.external;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @Deprecated(since = "release-1.2.0", forRemoval = true)
    @ResponseStatus(code = HttpStatus.OK, reason = "Test Success")
    public String test() { //
        return "test";
    }


    @GetMapping("/export")
    @ResponseBody
    public ResponseEntity<Resource> testExport() {
        String testJSON = """
                {
                  "test": "Test"
                }
                """;
        byte[] bytes = testJSON.getBytes();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=export.sh")
                .body(new ByteArrayResource(bytes));
    }
}
