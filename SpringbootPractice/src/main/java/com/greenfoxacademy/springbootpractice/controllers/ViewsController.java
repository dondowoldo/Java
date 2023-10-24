package com.greenfoxacademy.springbootpractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewsController {


    @RequestMapping("/table")
    public String table() {
        return "table";
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }
}
