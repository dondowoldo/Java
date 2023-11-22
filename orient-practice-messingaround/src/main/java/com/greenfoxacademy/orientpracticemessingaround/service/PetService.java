package com.greenfoxacademy.orientpracticemessingaround.service;

import com.greenfoxacademy.orientpracticemessingaround.model.Pet;
import com.greenfoxacademy.orientpracticemessingaround.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private PetRepository pets;

    public PetService(PetRepository pets) {
        this.pets = pets;
    }

    public Optional<Pet> findById(Long id) {
        return pets.findById(id);
    }

    public Optional<Pet> findByName(String name) {
        return pets.findByName(name);
    }

    public List<Pet> findAll() {
        return pets.findAll();
    }

    public Pet save(Pet pet) {
        return pets.save(pet);
    }

    public List<Pet> findAllWithoutOwner() {
        return pets.findAllByOwnerIsNull();
    }

}
