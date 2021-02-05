package org.kaliada;

public class Latte extends Coffee{
    private int milk;

    public Latte(int coffee, int water, int milk) {
        super(coffee, water);
        this.milk = milk;
    }

    @Override
    public void makeCoffee() {
        System.out.println("make Latte");
    }

    public int getMilk() {
        return milk;
    }
}
