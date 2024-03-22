package com.project.gestao_vagas.modules.company.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.gestao_vagas.modules.company.dto.CreateJobDTO;

public class CreateJobControllerTest {
    
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    
    @SuppressWarnings("null")
    @Before
    public void setup(){
        
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @SuppressWarnings("null")
    @Test
    public void should_be_able_to_create_a_new_job() throws Exception{
        
        var createJobDTO = CreateJobDTO.builder()
        .benefits("BENEFITS_TEST")
        .description("DESCRIPTION_TEST")
        .level("LEVEL_TEST")
        .build();
        
        var result = mvc.perform(MockMvcRequestBuilders.post("/company/job")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectToJSON(createJobDTO)))
        .andExpect(MockMvcResultMatchers.status().isOk());

        System.out.println(result);
    }

    private static String objectToJSON(Object obj){

        try {

            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
}