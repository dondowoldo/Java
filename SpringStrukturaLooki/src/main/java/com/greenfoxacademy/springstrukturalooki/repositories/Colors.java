package com.greenfoxacademy.springstrukturalooki.repositories;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class Colors {
    private List<String> colors;

    public Colors() {
        this.colors = new ArrayList<>();

        colors.add("#f5f5f5"); // Silver
        colors.add("#e0e0e0"); // Grey
        colors.add("#dcdcdc"); // Light Grey
        colors.add("#c0c0c0"); // Medium Grey
        colors.add("#a9a9a9"); // Dark Grey
        colors.add("#ffffff"); // White
        colors.add("#f0f8ff"); // Alice Blue
        colors.add("#f0ffff"); // Azure
        colors.add("#f0f8ff"); // Alice Blue
        colors.add("#f5f5dc"); // Beige
        colors.add("#ffe4c4"); // Bisque
        colors.add("#ffebcd"); // Blanched Almond
        colors.add("#dda0dd"); // Plum
        colors.add("#b0e0e6"); // Powder Blue
        colors.add("#87cefa"); // Light Sky Blue
        colors.add("#add8e6"); // Light Blue
        colors.add("#e0ffff"); // Light Cyan
        colors.add("#98fb98"); // Pale Green
        colors.add("#90ee90"); // Light Green
        colors.add("#f0e68c"); // Khaki
        colors.add("#d2691e"); // Chocolate
        colors.add("#cd853f"); // Peru
        colors.add("#f4a460"); // Sandy Brown
        colors.add("#da70d6"); // Orchid
        colors.add("#ff69b4"); // Hot Pink
        colors.add("#ffc0cb"); // Pink
        colors.add("#dda0dd"); // Plum
        colors.add("#ee82ee"); // Violet
        colors.add("#a020f0"); // Purple
        colors.add("#7b68ee"); // Medium Slate Blue
    }

    public List<String> getColors() {
        return this.colors;
    }
}


