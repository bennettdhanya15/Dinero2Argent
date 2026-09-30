package com.example.demo.HomeController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 

public class RegisterContoller {
     @GetMapping("/signup")
    public String displaysignup() {
        return "converter.html";
    }


}
