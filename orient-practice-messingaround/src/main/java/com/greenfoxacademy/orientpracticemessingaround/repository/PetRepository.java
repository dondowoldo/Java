package com.greenfoxacademy.orientpracticemessingaround.repository;

import com.greenfoxacademy.orientpracticemessingaround.model.Pet;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends ListCrudRepository<Pet, Long> {

    List<Pet> findAllByOwnerIsNull();
    Optional<Pet> findByName(String name);
}
