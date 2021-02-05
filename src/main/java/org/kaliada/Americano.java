package org.kaliada;

public class Americano extends Coffee{

    public Americano(int coffee, int water) {
        super(coffee, water);
    }

    @Override
    public void makeCoffee() {
        System.out.println("make Americano");
    }
}
