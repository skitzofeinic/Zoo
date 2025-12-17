package com.ing.zoo.animals;

public abstract class Animal {
    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sayHello();

    public String getName() {
        return name;
    }
}
