package com.example.bootstrap2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("This is  Bootstrap application written by Ilmira");
        messages.add("1.0 version by march '02 ");
        model.addAttribute("messages", messages);
        return "index";
    }

}