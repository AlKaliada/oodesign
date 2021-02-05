package org.kaliada;

public abstract class Coffee {
    private int coffee;
    private int water;

    public Coffee(int coffee, int water) {
        this.coffee = coffee;
        this.water = water;
    }

    public abstract void makeCoffee();

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
