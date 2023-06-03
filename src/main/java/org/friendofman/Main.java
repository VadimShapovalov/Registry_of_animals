package org.friendofman;

public class Main {
    public static void main(String[] args) throws Exception {
        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.read();

        Menu menu = new Menu();
        menu.menu();

        WriteToFile writeToFile = new WriteToFile();
        writeToFile.wright();

    }
}
