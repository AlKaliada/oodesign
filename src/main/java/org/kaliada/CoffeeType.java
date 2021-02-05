package org.kaliada;

public enum CoffeeType {
    AMERICANO(2.1, 3, 2),
    LATTE(1.5, 2, 1, 2),
    MAROCCHINO(2.5, 1, 2, 1, 1);
    private double price;
    private int coffee;
    private int water;
    private int milk;
    private int chocolate;

    CoffeeType(double price, int coffee, int water, int milk, int chocolate) {
        this(price, coffee, water, milk);
        this.chocolate = chocolate;
    }

    CoffeeType(double price, int coffee, int water, int milk) {
        this(price, coffee, water);
        this.milk = milk;
    }

    CoffeeType(double price, int coffee, int water) {
        this.price = price;
        this.coffee = coffee;
        this.water = water;
    }

    public double getPrice() {
        return price;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getChocolate() {
        return chocolate;
    }
}
