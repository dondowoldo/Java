package com.greenfoxacademy.springstrukturalooki.controllers;

import com.greenfoxacademy.springstrukturalooki.services.ColorService;
import com.greenfoxacademy.springstrukturalooki.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private GreetingService greetingService;
    private ColorService colorService;
    private static int viewCount = 0;

    @Autowired
    public WebController(GreetingService greetingService, ColorService colorService) {
        this.greetingService = greetingService;
        this.colorService = colorService;
    }

    @GetMapping("/greetings")
    public String greet(Model model,
                        @RequestParam(name="contains", required = false) String contains,
                        @RequestParam(name="minimum_length", required = false) Integer min) {

        viewCount++;
        model.addAttribute("viewCount", viewCount);
        model.addAttribute("greetings", greetingService.getFiltered(contains, min));
        model.addAttribute("color", colorService.getRandomColor());
        return "greeting";
    }
}
