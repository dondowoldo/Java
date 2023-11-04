package com.greenfoxacademy.springstrukturalooki.services;


import com.greenfoxacademy.springstrukturalooki.repositories.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingService {

    private Greetings greetings;
    private static int viewCount = 0;

    @Autowired
    public GreetingService(Greetings greetings) {
        this.greetings = greetings;
    }

    public List<String> getAll() {
        return greetings.getGreetings();
    }

    public List<String> getFiltered(String contains, Integer min) {
        if (contains == null && min == null) {
            return getAll();
        }
        if (min == null && contains != null) {
            return greetings.getGreetings().stream()
                    .filter(greeting -> greeting.contains(contains))
                    .collect(Collectors.toList());
        }
        if (contains == null && min != null) {
            return greetings.getGreetings().stream()
                    .filter(greeting -> greeting.length() >= min)
                    .collect(Collectors.toList());
        }
        return greetings.getGreetings().stream()
                .filter(greeting -> greeting.length() >= min)
                .filter(greeting -> greeting.contains(contains))
                .collect(Collectors.toList());
    }

    public void increaseViewCount() {
        viewCount++;
    }

    public int getViewCount() {
        return viewCount;
    }

}
