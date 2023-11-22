package com.greenfoxacademy.orientpracticemessingaround.repository;

import com.greenfoxacademy.orientpracticemessingaround.model.Human;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface HumanRepository extends ListCrudRepository<Human, Long> {
    Optional<Human> findByName(String name);

}
