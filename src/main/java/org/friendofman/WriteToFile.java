package org.friendofman;

import java.io.*;
import java.util.ArrayList;
import static org.friendofman.Counter.count;
import static org.friendofman.PetRegistry.registry;
public class WriteToFile implements Serializable {
    public ArrayList<Animal> registr = registry;
    int id;
    public void  wright() {
        registr = registry;
        id = count;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registry.txt"))) {
            oos.writeObject(registr);
            oos.writeInt(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




