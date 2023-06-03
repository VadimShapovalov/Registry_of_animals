package org.friendofman;

import java.io.Serializable;
import java.util.ArrayList;

public class PetRegistry implements Serializable {
    static ArrayList<Animal> registry = new ArrayList<>();

    public static void addRegistry(Animal animal) {
        registry.add(animal);
    }


}
