package com.greenfoxacademy.orientpracticemessingaround.service;

import com.greenfoxacademy.orientpracticemessingaround.model.Human;
import com.greenfoxacademy.orientpracticemessingaround.repository.HumanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private HumanRepository people;

    public HumanService(HumanRepository humans) {
        this.people = humans;
    }

    public Optional<Human> findById(Long id) {
        return people.findById(id);
    }

    public Optional<Human> findByName(String name) {
        return people.findByName(name);
    }

    public List<Human> findAll() {
        return people.findAll();
    }

    public Human save(Human human) {
        return people.save(human);
    }

}
