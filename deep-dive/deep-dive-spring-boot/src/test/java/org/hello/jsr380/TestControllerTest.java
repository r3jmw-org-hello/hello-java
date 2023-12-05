package org.hello.jsr380;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testNotBlankWorks() throws Exception {
        this.mockMvc
                .perform(get("/test").param("test", ""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testRequestBody() throws Exception {
        TestModel testModel = new TestModel(null, null, null, null, "2", new TestSubModel(null, null));
        this.mockMvc
                .perform(
                        post("/test")
                                .content(objectMapper.writeValueAsBytes(testModel))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testNestedRequestBody() throws Exception {
        TestModel testModel = new TestModel(1L, 1L, 1L, 1L, "2", new TestSubModel(null, "subName"));
        this.mockMvc
                .perform(
                        post("/test")
                                .content(objectMapper.writeValueAsBytes(testModel))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGroups() throws Exception {
        TestModel testModel = new TestModel(null, 1L, 1L, 1L, "2", new TestSubModel(1L, "subName"));
        this.mockMvc
                .perform(
                        post("/test/groups")
                                .content(objectMapper.writeValueAsBytes(testModel))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void test_validated_groups_all() throws Exception {
        TestModel testModel = new TestModel(1L, 1L, 1L, null, "2", new TestSubModel(1L, "subName"));
        this.mockMvc
                .perform(
                        post("/test/groups/all")
                                .content(objectMapper.writeValueAsBytes(testModel))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
