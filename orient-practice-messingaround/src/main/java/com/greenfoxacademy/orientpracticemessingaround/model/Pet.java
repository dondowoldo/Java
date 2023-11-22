package com.greenfoxacademy.orientpracticemessingaround.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pet {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String type;
    @ManyToOne
    private Human owner;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Pet(String name, String type, Human owner) {
        this(name, type);
        this.owner = owner;
    }
}
