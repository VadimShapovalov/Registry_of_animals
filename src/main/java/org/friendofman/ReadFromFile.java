package org.friendofman;

import java.io.*;
import java.util.ArrayList;

import static org.friendofman.PetRegistry.registry;
import static org.friendofman.Counter.count;
public class ReadFromFile implements Serializable {
    public ArrayList<Animal> reg = new ArrayList<>();
    public int id;
    public void read(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registry.txt"))){
            reg = (ArrayList<Animal>) ois.readObject();
            id = ois.readInt();
            registry = reg;
            count = id;
        } catch ( IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
