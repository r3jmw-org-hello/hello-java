package org.hello.jsr380;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


//@Validated
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> test(@RequestParam(value = "test") @NotEmpty String test) {
        return ResponseEntity.ok().body(test);
    }

    @PostMapping(value = "/test")
    public ResponseEntity<TestModel> test(@RequestBody @Validated TestModel testModel) {
        return ResponseEntity.ok().body(testModel);
    }

    @PostMapping(value = "/test/groups")
    public ResponseEntity<TestModel> testGroups(@RequestBody @Validated(value = {TestModel.Create.class}) TestModel testModel) {
        return ResponseEntity.ok().body(testModel);
    }

    @PostMapping(value = "/test/groups/all")
    public ResponseEntity<TestModel> testGroupsAll(
            @RequestBody
            @Validated(value = {TestModel.All.class})
            TestModel testModel
    ) {
        return ResponseEntity.ok().body(testModel);
    }
}
