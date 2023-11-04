package com.greenfoxacademy.springstrukturalooki.services;


import com.greenfoxacademy.springstrukturalooki.repositories.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GreetingService {

    private Greetings greetings;

    @Autowired
    public GreetingService(Greetings greetings) {
        this.greetings = greetings;
    }

    public List<String> getAll() {
        return greetings.getGreetings();
    }

    public List<String> getFiltered(String contains, Integer min) {
        Stream<String> filtered = greetings.getGreetings().stream();

        if (min != null) {
            filtered = filtered.filter(greeting -> greeting.length() >= min);
        }
        if (contains != null) {
            filtered = filtered.filter(greeting -> greeting.contains(contains));
        }
        return filtered.collect(Collectors.toList());
    }
}
