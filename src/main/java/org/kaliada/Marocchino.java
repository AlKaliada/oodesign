package org.kaliada;

public class Marocchino extends Coffee{
    private int milk;
    private int chocolate;

    public Marocchino(int coffee, int water, int milk, int chocolate) {
        super(coffee, water);
        this.milk = milk;
        this.chocolate = chocolate;
    }

    @Override
    public void makeCoffee() {
        System.out.println("make Marocchino");
    }

    public int getMilk() {
        return milk;
    }

    public int getChocolate() {
        return chocolate;
    }
}
