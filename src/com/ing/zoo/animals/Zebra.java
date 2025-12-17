package com.ing.zoo.animals;

import com.ing.zoo.interfaces.consumers.Herbivore;

public class Zebra extends Animal implements Herbivore {
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
}
