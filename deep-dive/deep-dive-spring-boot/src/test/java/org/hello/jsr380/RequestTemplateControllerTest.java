package org.hello.jsr380;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hello.jsr380.model.RequestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@link RequestTemplateController}
 */
@WebMvcTest
public class RequestTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_request_template_validate_creation() throws Exception {
        RequestTemplate requestTemplate = new RequestTemplate(null, null);
        this.mockMvc
                .perform(
                        post("/request-template")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsBytes(requestTemplate))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void test_request_template_validate_update() throws Exception {
        RequestTemplate requestTemplate = new RequestTemplate(null, null);
        this.mockMvc
                .perform(
                        put("/request-template")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsBytes(requestTemplate))
                )
                .andExpect(status().isBadRequest());
    }
}
