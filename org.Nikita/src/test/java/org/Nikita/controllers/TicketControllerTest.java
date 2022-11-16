package org.Nikita.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest

//@WebMvcTest
//@AutoConfigureWebMvc
//@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureWebMvc
@AutoConfigureMockMvc
class TicketControllerTest {


    @Autowired
    private TicketController controller;
    private MockMvc mockMvc;

//    @Autowired
//    public TicketControllerTest(TicketController controller, MockMvc mockMvc){
//        this.mockMvc = mockMvc;
//        this.controller = controller;
//    }

    @Test
    void init() {
        assertNotNull(controller);
    }

    @Test
    void getAllTickets() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/api/tickets")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createTicket() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByFromCity() {
    }

    @Test
    void findByToCity() {
    }
}