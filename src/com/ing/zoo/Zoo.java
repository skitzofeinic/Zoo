package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.interfaces.TrickPerformer;
import com.ing.zoo.interfaces.consumers.Carnivore;
import com.ing.zoo.interfaces.consumers.Herbivore;

import java.util.Scanner;
import java.util.function.Consumer;

public class Zoo {
    static void main() {
        String[] commands = new String[4];
        commands[0] = "hello";
        commands[1] = "give leaves";
        commands[2] = "give meat";
        commands[3] = "perform trick";

        Animal[] animals = {
                new Lion("Henk"),
                new Hippo("Elsa"),
                new Pig("Dora"),
                new Tiger("Wally"),
                new Zebra("Marty"),
                new Monkey("harambe"),
                new Panda("zihao")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer uw command in: ");
        String input = scanner.nextLine().trim().replaceAll("\\s+", " ");

        String[] parts = input.split(" ");
        String command = parts[0].toLowerCase();
        String target = parts.length > 1 ? parts[1] : "";

        if (command.equals(commands[0])) {
            if (target.isEmpty()) {
                for (Animal animal : animals) {
                    animal.sayHello();
                } return;
            }
            Animal foundAnimal = findAnimalByName(animals, target);
            if (foundAnimal == null) {
                System.out.println("No animal named " + target + " found."); return;
            }
            foundAnimal.sayHello();
        }

        switch (command) {
            case "give leaves" -> performActionOnType(animals, Herbivore.class, Herbivore::eatLeaves, "No herbivores available to eat leaves.");
            case "give meat" -> performActionOnType(animals, Carnivore.class, Carnivore::eatMeat, "No carnivores available to eat meat.");
            case "perform trick" -> performActionOnType(animals, TrickPerformer.class, TrickPerformer::performTrick, "No animals can perform tricks.");
            default -> System.out.println("Unknown command: " + input);
        }
    }

    private static <T> void performActionOnType(Animal[] animals, Class<T> type, Consumer<T> action, String errorMessage) {
        boolean anyFound = false;
        for (Animal animal : animals) {
            if (type.isInstance(animal)) {
                action.accept(type.cast(animal));
                anyFound = true;
            }
        }
        if (!anyFound) System.out.println(errorMessage);
    }

    private static Animal findAnimalByName(Animal[] animals, String target) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(target)) {
                return animal;
            }
        }
        return null;
    }
}
