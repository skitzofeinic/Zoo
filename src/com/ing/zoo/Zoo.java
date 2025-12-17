package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.interfaces.TrickPerformer;
import com.ing.zoo.interfaces.consumers.Carnivore;
import com.ing.zoo.interfaces.consumers.Herbivore;

import java.util.Scanner;

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
                new Tiger("wally"),
                new Zebra("Marty"),
                new Panda("Zhao"),
                new Monkey("Hare")
        };

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Voer uw command in: ");
            String input = scanner.nextLine().trim().replaceAll("\\s+", " ");

            String[] parts = input.split(" ");

            String command;
            if (parts.length == 1) command = parts[0].toLowerCase();
            else command = (parts[0] + " " + parts[1]).toLowerCase();

            String target = parts.length > 2 ? parts[2] : "";

            int cidx = -1;
            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equalsIgnoreCase(command)) {
                    cidx = i;
                    break;
                }
            }

            if (cidx == -1) {
                System.out.println("command not found");
                return;
            }

            switch (cidx) {
                case 0 -> sayHello(animals, target);
                case 1 -> feedHerbivores(animals);
                case 2 -> feedCarnivores(animals);
                case 3 -> performTricks(animals);
                default -> System.out.println("Unknown command: " + command);
            }
        }
    }

    private static void sayHello(Animal[] animals, String target) {
        if (target.isEmpty()) {
            for (Animal animal : animals) animal.sayHello();
        } else {
            Animal found = findAnimalByName(animals, target);
            if (found == null) System.out.println("No animal named " + target + " found.");
            else found.sayHello();
        }
    }

    private static void feedHerbivores(Animal[] animals) {
        for (Animal a : animals) if (a instanceof Herbivore h) h.eatLeaves();
    }

    private static void feedCarnivores(Animal[] animals) {
        for (Animal a : animals) if (a instanceof Carnivore c) c.eatMeat();
    }

    private static void performTricks(Animal[] animals) {
        for (Animal a : animals) if (a instanceof TrickPerformer t) t.performTrick();
    }

    private static Animal findAnimalByName(Animal[] animals, String target) {
        for (Animal animal : animals) {
            if (animal.getName().equals(target)) return animal;
        }
        return null;
    }
}
