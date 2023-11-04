package com.greenfoxacademy.springbootpractice.controllers;


import com.greenfoxacademy.springbootpractice.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewsController {
    private List<Person> personList= new ArrayList<>();

    public ViewsController() {
        personList.add(new Person("Joey", 30, "male"));
        personList.add(new Person("Rachel", 29, "female"));
        personList.add(new Person("Ross", 31, "male"));
        personList.add(new Person("Monica", 32, "female"));
    }


    @GetMapping("/form")
    public String form(Model model) {

        model.addAttribute("newPerson", new Person());
        model.addAttribute("personList", personList);
        return "form";
    }

    @PostMapping("/form")
    public String add(@ModelAttribute Person newPerson, Model model) {
        newPerson.setId(Person.incrementID());
        personList.add(newPerson);

        model.addAttribute("newPerson", new Person());
        model.addAttribute("personList", personList);
        return "form";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int id) {
        personList.removeIf(p -> p.getId() == id);
        return "redirect:/form";
    }
}
