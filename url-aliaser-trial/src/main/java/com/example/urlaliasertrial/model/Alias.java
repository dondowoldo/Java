package com.example.urlaliasertrial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alias {

    @Id @GeneratedValue
    private Long id;
    private String alias;
    private Integer hitCount;
    private String secretCode;
    @ManyToOne
    private Link link;

    public Alias(String alias) {
        this.alias = alias;
        this.secretCode = generateSecret();
        this.hitCount = 0;
    }

    public Alias(String alias, Link link) {
        this(alias);
        this.link = link;
    }

    public String generateSecret() {
        int secretLength = 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secretLength; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

    public void increaseHitCount() {
        this.hitCount += 1;
    }
}
