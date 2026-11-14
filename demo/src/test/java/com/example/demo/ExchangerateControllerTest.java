package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.HomeController.ExchangerateController;
import com.example.demo.HomeController.RegisterContoller;
import com.example.demo.Repository.exchangeraterepo;
import com.example.demo.domain.exchangerate;

@WebMvcTest({ ExchangerateController.class, RegisterContoller.class })
class ExchangerateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private exchangeraterepo repository;

    private exchangerate rate(String from, String to, double value) {
        exchangerate r = new exchangerate();
        r.setFromCurrency(from);
        r.setToCurrency(to);
        r.setRate(value);
        return r;
    }

    @Test
    void ratesEndpointReturnsAllRates() throws Exception {
        when(repository.findAll()).thenReturn(List.of(
                rate("USD", "INR", 83.0),
                rate("EUR", "INR", 90.5)));

        mockMvc.perform(get("/api/rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].fromCurrency").value("USD"))
                .andExpect(jsonPath("$[0].toCurrency").value("INR"))
                .andExpect(jsonPath("$[0].rate").value(83.0))
                .andExpect(jsonPath("$[1].fromCurrency").value("EUR"));
    }

    @Test
    void ratesEndpointReturnsEmptyListWhenNoRates() throws Exception {
        when(repository.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void signupPageIsServed() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("converter.html"));
    }
}