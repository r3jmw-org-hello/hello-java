package org.hello.jsr380;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.hello.jsr380.model.RequestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class RequestTemplateController {

    @PostMapping("/request-template")
    public ResponseEntity<RequestTemplate> createRequestTemplate(@RequestBody @Validated({RequestTemplate.Creation.class}) RequestTemplate requestTemplate) {
        return ResponseEntity.ok(requestTemplate);
    }

    @PutMapping("/request-template")
    public ResponseEntity<RequestTemplate> updateRequestTemplate(@RequestBody @Validated({RequestTemplate.Update.class}) RequestTemplate requestTemplate) {
        return ResponseEntity.ok(requestTemplate);
    }

    @PutMapping("/request-template/batch")
    public ResponseEntity<List<RequestTemplate>> updateRequestTemplateBatch(@RequestBody @NotEmpty List<@Valid RequestTemplate> requestTemplate) {
        return ResponseEntity.ok(requestTemplate);
    }
}
