package com.greenfoxacademy.springstrukturalooki.repositories;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Greetings {
    private static List<String> greetings;

    public Greetings() {
        greetings = new ArrayList<>();
        greetings.add("hello");
        greetings.add("hi");
        greetings.add("ahoj");
        greetings.add("čau");
        greetings.add("konichiwa");
        greetings.add("buongiorno");
    }

    public List<String> getGreetings() {
        return Greetings.greetings;
    }
}
