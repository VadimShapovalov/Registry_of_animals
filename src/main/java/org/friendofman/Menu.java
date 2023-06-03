package org.friendofman;

import java.util.Scanner;

public class Menu {
    public void menu() throws Exception {
        System.out.println("Здравствуйте!");
        Scanner scannerr = new Scanner(System.in);
        boolean flag = true;
        String choice;
        while (flag) {

            System.out.println("Выберете порядковый номер действия, которое хотите совершить: \n" +
                    "1. Зарегистрировать новое животное.\n2. Найти животное в реестре.\n" +
                    "3. Увидеть список команд, которые исполняет животное.\n4. Обучить животное.\n" +
                    "5. Показать всех животных в реестре\n6. Выйти из программы.");
            choice = scannerr.nextLine();
            Model model = new Model();
            switch (choice) {
                case "1" -> model.addAnimals();
                case "2" -> {
                    Animal animal = model.findAnimals();
                    if (animal == null) System.out.println("Такого животного нет в реестре.");
                    else {
                        System.out.println("Информация о животном, которое Вы искали: ");
                        System.out.println(animal);
                    }
                }
                case "3" -> model.showCommands(model.findAnimals());
                case "4" -> model.trainAnimals(model.findAnimals());
                case "5" -> model.showAllAnimals();
                case "6" -> {
                    flag = false;
                    System.out.println("До новых встреч!");
                    scannerr.close();
                }
                default -> System.out.println("Вы ввели некорректные данные");
            }
        }
    }

}
