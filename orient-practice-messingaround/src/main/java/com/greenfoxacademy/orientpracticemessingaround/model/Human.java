package com.greenfoxacademy.orientpracticemessingaround.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Human {
    @Id @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
//    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    public Human(String name) {
        this.name = name;
    }


}
