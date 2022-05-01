package com.jh.scrumble.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SampleController.class)
public class SampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void sample_return() throws Exception {
        String sample = "SAMPLE";

        mvc.perform(get("/sample"))
            .andExpect(status().isOk())
            .andExpect(content().string(sample));
    }

    @Test
    public void sample_dto_return() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/sample/dto").param("name", name).param("amount", String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount", is(amount)));
    }
}
