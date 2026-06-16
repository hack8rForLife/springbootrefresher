package com.example.springbootfullrefresher.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/main")
    public String Home(){
        return "taco";
    }
}
