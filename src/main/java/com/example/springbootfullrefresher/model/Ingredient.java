package com.example.springbootfullrefresher.model;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Ingredient {

    private  String id;
    private  String name;
    private  Type type;

    public Ingredient(String flto, String flourTortilla, Type type) {
        this.id = flto;
        this.name = flourTortilla;
        this.type = type;
    }

    public static enum Type {
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE;
        public String toString;
    }
}
