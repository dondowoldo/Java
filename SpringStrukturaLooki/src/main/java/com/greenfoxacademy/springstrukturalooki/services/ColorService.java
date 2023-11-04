package com.greenfoxacademy.springstrukturalooki.services;


import com.greenfoxacademy.springstrukturalooki.repositories.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ColorService {
    private Colors colors;

    @Autowired
    public ColorService(Colors colors) {
        this.colors = colors;
    }

    public String getRandomColor() {
        Random random = new Random();
        int index = random.nextInt(colors.getColors().size());
        return colors.getColors().get(index);
    }
}
