package com.example.urlaliasertrial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Link {
    @Id @GeneratedValue
    private Long id;
    private String url;
    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL)
    private List<Alias> aliases = new ArrayList<>();

    public Link(String url) {
        this.url = url;
    }
}
