package com.example.timezone.controller;

import com.example.timezone.dto.TimeZoneResponseDTO;
import com.example.timezone.service.TimeZoneService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class TimeZoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeZoneService timeZoneService;


    @Test
    public void testValidUSTimeZone() throws Exception {
        String timezone = "America/New_York";

        TimeZoneResponseDTO validResponse = new TimeZoneResponseDTO("EDT", "America/New_York", "datetime");

        Mockito.when(timeZoneService.getTimeZoneInfo(timezone)).thenReturn(validResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/time")
                        .param("timezone", timezone))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.abbreviation", Matchers.is("EDT")))
                .andExpect(jsonPath("$.timezone", Matchers.is("America/New_York")));
    }


    @Test
    public void testInValidUSTimeZone() throws Exception {
        String timezone = "ABCD";
        Mockito.when(timeZoneService.getTimeZoneInfo(timezone)).thenThrow(new RuntimeException(""));
        mockMvc.perform(MockMvcRequestBuilders.get("/time")
                        .param("timezone", timezone))
                .andExpect(status().isBadRequest());
    }

}