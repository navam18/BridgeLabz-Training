package com.bridgelabz.greetings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingFormController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/greet")
    public String showGreeting(@RequestParam(name = "visitorName", required = false, defaultValue = "Guest") String visitorName,
                                Model model) {
        model.addAttribute("visitorName", visitorName);
        return "greeting";
    }
}
