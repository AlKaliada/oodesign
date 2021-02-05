package org.kaliada;

public class Ingredients {
    private int chocolate;
    private int coffee;
    private int milk;
    private int water;

    public Ingredients() {
        chocolate = 500;
        coffee = 500;
        milk = 500;
        water = 1000;
    }

    public int getChocolate() {
        return chocolate;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int takeChocolate(int chocolate) {
        this.chocolate -= chocolate;
        return chocolate;
    }

    public int takeCoffee(int coffee) {
        this.coffee -= coffee;
        return coffee;
    }

    public int takeMilk(int milk) {
        this.milk -= milk;
        return milk;
    }

    public int takeWater(int water) {
        this.water -= water;
        return water;
    }

    public void addChocolate(int chocolate) {
        this.chocolate += chocolate;
    }

    public void addCoffee(int coffee) {
        this.coffee += coffee;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void addWater(int water) {
        this.water += water;
    }
}
