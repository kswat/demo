package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PersonService personService;

    @Test
    void given_person_save() throws Exception{
        var inPerson = new Person("First","Last");

//        when(personService.createPerson(ArgumentMatchers.eq(inPerson))).thenReturn(Optional.of(inPerson));
        when(personService.createPerson( any(Person.class)) ).thenReturn(Optional.of(inPerson));

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inPerson)))
                .andExpect(status().isCreated());
    }

    /**
     * THIS TEST IS FAILING, when using exact match - eq
     * @throws Exception
     */
    @Test
    void given_exact_person_save() throws Exception {
        var inPerson = new Person("First","Last");

        when(personService.createPerson(ArgumentMatchers.eq(inPerson))).thenReturn(Optional.of(inPerson));

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inPerson)))
                .andExpect(status().isCreated());
    }
}