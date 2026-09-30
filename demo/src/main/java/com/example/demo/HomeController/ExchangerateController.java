package com.example.demo.HomeController;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.exchangerate;
import com.example.demo.Repository.exchangeraterepo;

@RestController
@RequestMapping("/api")
public class ExchangerateController {

    private final exchangeraterepo repository;

    public ExchangerateController(exchangeraterepo repository) {
        this.repository = repository;
    }

    @GetMapping("/rates")
    public List<exchangerate> getRates() {
        return repository.findAll();
    }
}