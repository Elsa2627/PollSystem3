package com.yourcompany.pollservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PollControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPollQuestionEndpoint() throws Exception {
        ResultActions perform = mockMvc.perform(get("/api/polls/questions/1"));
    }
}