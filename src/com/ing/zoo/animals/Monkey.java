package com.ing.zoo.animals;

import com.ing.zoo.interfaces.consumers.Carnivore;
import com.ing.zoo.interfaces.consumers.Herbivore;

public class Monkey extends Animal implements Herbivore, Carnivore {
    public String name;
    public String helloText;
    public String eatText;

    public Monkey(String name) {
        super(name);
    }

    public void sayHello() {
        helloText = "oh oh ah ah";
        System.out.println(helloText);
    }

    public void eatLeaves() {
        eatText = "bananannana";
        System.out.println(eatText);
    }

    @Override
    public void eatMeat() {
        eatText = "gnomomgonm meat";
        System.out.println(eatText);
    }
}
