package org.friendofman;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static org.friendofman.Counter.count;
import static org.friendofman.PetRegistry.registry;

public class Model {
    public void addAnimals() {
        int id;
        String typeAnimal = null;
        String kindOfAnimal = null;
        String name = null;
        LocalDate dateOfBirth = null;
        Set<Comma> commandsSet = new TreeSet<>();
        String signal = "";
        Scanner scanner = new Scanner(System.in);
        while (!signal.equals("y")) {
            String choice;
            System.out.println("Выберете тип животного:\n1. Вьючное животное.\n2. Домашний питомец.");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Ваш выбор: Вьючное животное. Если верно нажмите \"y\", если нет, нажмите \"n\".\n");
                    typeAnimal = "Вьючное животное";
                    signal = scanner.nextLine().toLowerCase();
                }
                case "2" -> {
                    System.out.println("Ваш выбор: Домашний питомец. Если верно нажмите \"y\", если нет, нажмите \"n\".");
                    typeAnimal = "Домашний питомец";
                    signal = scanner.nextLine().toLowerCase();
                }
                default -> System.out.println("Вы ввели некорректные данные, пожалуйста, повторите попытку.\n");
            }
        }
        signal = "";
        while (!signal.equals("y")) {
            String choice;
            if (typeAnimal.equals("Вьючное животное")) {
                System.out.println("Выберете кого Вы хотите добавить:\n1. Лошадь \n2. Верблюд \n3. Осел");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> kindOfAnimal = "Лошадь";
                    case "2" -> kindOfAnimal = "Верблюд";
                    case "3" -> kindOfAnimal = "Осел";
                    default -> System.out.println("Вы ввели некорректные данные, пожалуйста, повторите попытку.");
                }
            } else {
                System.out.println("Выберете кого Вы хотите добавить:\n1. Кошка \n2. Собака \n3. Хомяк");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> kindOfAnimal = "Кошка";
                    case "2" -> kindOfAnimal = "Собака";
                    case "3" -> kindOfAnimal = "Хомяк";
                    default -> {
                        System.out.println("Вы ввели некорректные данные, пожалуйста, повторите попытку.");
                        continue;
                    }
                }
            }
            System.out.printf("Ваш выбор %s. Ecли верно, нажмите \"y\", если нет, нажмите \"n\".\n", kindOfAnimal);
            signal = scanner.nextLine().toLowerCase();
        }
        signal = "";
        while (!signal.equals("y")) {
            System.out.println("Введите имя животного");
            name = scanner.nextLine();
            if (name.trim().length() < 1) continue;
            System.out.printf("Вы ввели %s. Если имя верное нажмите \"y\", если нет, нажмите \"n\".\n", name);
            signal = scanner.nextLine().toLowerCase();
        }
        signal = "";
        while (!signal.equals("y")) {
            System.out.println("Введите месяц и год рождения животного в формате \"mm.yyyy\".");
            try {
                String[] arr = scanner.nextLine().split("\\.");
                if (arr.length != 2) throw new IOException();
                dateOfBirth = LocalDate.of(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]), 1);
            } catch (IOException | DateTimeException | NumberFormatException ex) {
                System.out.println("Вы ввели некорректные данные. Пожалуйста, повторите ввод.");
                continue;
            }
            System.out.printf("Вы ввели %s.%d Если дата рождения верна нажмите \"y\", если нет, нажмите \"N\".\n",
                    dateOfBirth.getMonth(), dateOfBirth.getYear());
            signal = scanner.nextLine().toLowerCase();
        }
        signal = "";
        System.out.println("Если Ваше животное НЕ умеет выполнять команды, нажмите \"y\", если умеет, нажмите \"n\".");
        signal = scanner.nextLine().toLowerCase();
        while (!signal.equals("y")) {
            String choice;
            System.out.println("Введите из списка номер команды, которую хотите внести:\n");
            System.out.println("1.Вперед  2.Сидеть  3.Лежать  4.Стоять  5. Принеси  6. Голос\n" +
                    "7.Охранять  8.Гулять  9.Место  10.Домой  11.Ко мне");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> commandsSet.add(Comma.ВПЕРЕД);
                case "2" -> commandsSet.add(Comma.СИДЕТЬ);
                case "3" -> commandsSet.add(Comma.ЛЕЖАТЬ);
                case "4" -> commandsSet.add(Comma.СТОЯТЬ);
                case "5" -> commandsSet.add(Comma.ПРИНЕСИ);
                case "6" -> commandsSet.add(Comma.ГОЛОС);
                case "7" -> commandsSet.add(Comma.ОХРАНЯТЬ);
                case "8" -> commandsSet.add(Comma.ГУЛЯТЬ);
                case "9" -> commandsSet.add(Comma.МЕСТО);
                case "10" -> commandsSet.add(Comma.ДОМОЙ);
                case "11" -> commandsSet.add(Comma.КО_МНЕ);
                default -> System.out.println("Вы ввели некорректные данные, пожалуйста, повторите попытку.");
            }
            System.out.println("Если Вы хотите выйти, нажмите \"y\",если хотите внести еще команду, нажмите \"n\".");
            signal = scanner.nextLine().toLowerCase();
        }
        Counter counter = new Counter();
        counter.add();
        id = count;
        switch (kindOfAnimal) {
            case "Кошка" -> {
                Cat cat = new Cat();
                cat.setId(id);
                cat.setTypeAnimal(typeAnimal);
                cat.setKindOfAnimal(kindOfAnimal);
                cat.setName(name);
                cat.setDateOfBirth(dateOfBirth);
                cat.setCommaSet(commandsSet);
                registry.add(cat);
            }
            case "Собака" -> {
                Dog dog = new Dog();
                dog.setId(id);
                dog.setTypeAnimal(typeAnimal);
                dog.setKindOfAnimal(kindOfAnimal);
                dog.setName(name);
                dog.setDateOfBirth(dateOfBirth);
                dog.setCommaSet(commandsSet);
                registry.add(dog);
            }
            case "Хомяк" -> {
                Hamster hamster = new Hamster();
                hamster.setId(id);
                hamster.setTypeAnimal(typeAnimal);
                hamster.setKindOfAnimal(kindOfAnimal);
                hamster.setName(name);
                hamster.setDateOfBirth(dateOfBirth);
                hamster.setCommaSet(commandsSet);
                registry.add(hamster);
            }
            case "Лошадь" -> {
                Horse horse = new Horse();
                horse.setId(id);
                horse.setTypeAnimal(typeAnimal);
                horse.setKindOfAnimal(kindOfAnimal);
                horse.setName(name);
                horse.setDateOfBirth(dateOfBirth);
                horse.setCommaSet(commandsSet);
                registry.add(horse);
            }
            case "Верблюд" -> {
                Camel camel = new Camel();
                camel.setId(id);
                camel.setTypeAnimal(typeAnimal);
                camel.setKindOfAnimal(kindOfAnimal);
                camel.setName(name);
                camel.setDateOfBirth(dateOfBirth);
                camel.setCommaSet(commandsSet);
                registry.add(camel);
            }
            case "Осел" -> {
                Donkey donkey = new Donkey();
                donkey.setId(id);
                donkey.setTypeAnimal(typeAnimal);
                donkey.setKindOfAnimal(kindOfAnimal);
                donkey.setName(name);
                donkey.setDateOfBirth(dateOfBirth);
                donkey.setCommaSet(commandsSet);
                registry.add(donkey);

            }
        }
        System.out.println("Животное успешно внесено в реестр.");
    }

    public Animal findAnimalId(String idd) {
        int id = Integer.parseInt(idd);
        Animal animal1 = null;
        boolean isAnimal = false;
        for (Animal animal : registry) {
            if (id == animal.getId()) {
                isAnimal = true;
                animal1 = animal;

            }
        }
        if (isAnimal) {
            System.out.println("Информация о животном, которое Вы искали: ");
            System.out.println(animal1);
            return animal1;
        } else {
            System.out.println("Животного с таким id в реестре нет.");
        }
        return null;
    }

    public Animal findAnimals() {
        String kindOfAnimals;
        Scanner scanner = new Scanner(System.in);
        String signal = "";
        Animal animal2 = null;
        while (!signal.equals("y")) {
            System.out.println("Выберите, какое животное Вы ищите:");
            System.out.println("1. Вьючное животное  2. Домашний питомец");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                String type;
                System.out.println("Выберите вид животного:");
                System.out.println("1.Лошадь  2.Верблюд  3.Осел");
                type = scanner.nextLine();
                switch (type) {
                    case "1" -> kindOfAnimals = "Лошадь";
                    case "2" -> kindOfAnimals = "Верблюд";
                    case "3" -> kindOfAnimals = "Осел";
                    default -> {
                        System.out.println("Вы ввели некорректные данные.");
                        continue;
                    }
                }
            } else if (choice.equals("2")) {
                String type;
                System.out.println("Выберите вид животного:");
                System.out.println("1.Кошка  2.Собака  3.Хомяк");
                type = scanner.nextLine();
                switch (type) {
                    case "1" -> kindOfAnimals = "Кошка";
                    case "2" -> kindOfAnimals = "Собака";
                    case "3" -> kindOfAnimals = "Хомяк";
                    default -> {
                        System.out.println("Вы ввели некорректные данные.");
                        continue;
                    }
                }
            } else {
                System.out.println("Вы ввели некорректные данные.");
                continue;
            }
            System.out.println("Напишите имя животного: ");
            String name = scanner.nextLine();
            LocalDate dateOfBirth = null;
            boolean correct = false;
            while (!correct) {
                System.out.println("Введите месяц и год рождения животного в формате \"mm.yyyy\".");
                try {
                    String[] arr = scanner.nextLine().split("\\.");
                    if (arr.length != 2) throw new IOException();
                    dateOfBirth = LocalDate.of(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]), 1);
                    correct = true;
                } catch (IOException | DateTimeException | NumberFormatException ex) {
                    System.out.println("Вы ввели некорректные данные. Пожалуйста, повторите ввод.");
                }
            }
            for (Animal a : registry) {

                if (a.getKindOfAnimal().equals(kindOfAnimals) && a.getName().equals(name) && a.getDateOfBirth().equals(dateOfBirth)) {
                    return a;
                } else {
                    System.out.println("Такого животного в реестре нет.");
                }
            }
            signal = "y";
        }

        return null;
    }
    public Set<Comma> showCommands(Animal animal) {
        if (animal == null) {
            System.out.println("Такого животного в реестре нет.");
        }
        else {
            System.out.println("Список команд, которые исполняет животное:");
            System.out.println(animal.getCommaSet());
            return animal.getCommaSet();
        }
        return null;
    }
    public void trainAnimals(Animal animal) {
        if (animal == null) {
            System.out.println("Такого животного нет.");
            return;
        } else {
            String signal = "";
            Scanner scanner = new Scanner(System.in);
            Set<Comma> commandsSet = animal.getCommaSet();
            while (!signal.equals("y")) {
                String choice;
                System.out.println("Введите из списка номер команды, которую хотите внести:\n");
                System.out.println("1.Вперед  2.Сидеть  3.Лежать  4.Стоять  5. Принеси  6. Голос\n" +
                        "7.Охранять  8.Гулять  9.Место  10.Домой  11.Ко мне");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> commandsSet.add(Comma.ВПЕРЕД);
                    case "2" -> commandsSet.add(Comma.СИДЕТЬ);
                    case "3" -> commandsSet.add(Comma.ЛЕЖАТЬ);
                    case "4" -> commandsSet.add(Comma.СТОЯТЬ);
                    case "5" -> commandsSet.add(Comma.ПРИНЕСИ);
                    case "6" -> commandsSet.add(Comma.ГОЛОС);
                    case "7" -> commandsSet.add(Comma.ОХРАНЯТЬ);
                    case "8" -> commandsSet.add(Comma.ГУЛЯТЬ);
                    case "9" -> commandsSet.add(Comma.МЕСТО);
                    case "10" -> commandsSet.add(Comma.ДОМОЙ);
                    case "11" -> commandsSet.add(Comma.КО_МНЕ);
                    default -> System.out.println("Вы ввели некорректные данные, пожалуйста, повторите попытку.");
                }
                System.out.println("Если Вы хотите выйти, нажмите \"y\",если хотите внести еще команду, нажмите \"n\".");
                signal = scanner.nextLine().toLowerCase();
            }
            animal.setCommaSet(commandsSet);
            System.out.println("Животное успешно обучено.");
        }
    }
    public void showAllAnimals() {
        if (registry.size() > 0) {
            System.out.println("Занесенные в реестр животные:");
            for (Animal a : registry) {
                System.out.println(a);
            }
        } else {
            System.out.println("Нет зарегистрированных животных.");
        }
    }

}
