package com.ing.zoo.animals;

import com.ing.zoo.interfaces.TrickPerformer;
import com.ing.zoo.interfaces.consumers.Herbivore;

import java.util.Random;

public class Zebra extends Animal implements Herbivore, TrickPerformer {
    public String name;
    public String helloText;
    public String eatText;
    public String trick;

    public Zebra(String name) {
        super(name);
    }

    public void sayHello()
    {
        helloText = "zebra zebra";
        System.out.println(helloText);
    }

    public void eatLeaves()
    {
        eatText = "munch munch zank yee bra";
        System.out.println(eatText);
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        int rnd = random.nextInt(3);
        switch (rnd) {
            case 0:
                trick = "scissor";
                break;
            case 1:
                trick = "rock";
                break;
            case 2:
                trick = "paper";
        }
    }
}
