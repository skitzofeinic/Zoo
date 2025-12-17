package com.ing.zoo.animals;

import com.ing.zoo.interfaces.consumers.Herbivore;

public class Panda extends Animal implements Herbivore {
    public String name;
    public String helloText;
    public String eatText;

    public Panda(String name) {
        super(name);
    }

    public void sayHello()
    {
        helloText = "panda";
        System.out.println(helloText);
    }

    public void eatLeaves()
    {
        eatText = "bamboo bamboo";
        System.out.println(eatText);
    }
}
