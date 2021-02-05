package org.kaliada;

public class CoffeeMachine {
    private Ingredients ingredients;
    private OrderingSystem orderingSystem;

    public CoffeeMachine(OrderingSystem orderingSystem) {
        this.orderingSystem = orderingSystem;
        ingredients = new Ingredients();
    }

    public void orderCoffee(CoffeeType type){
        if (checkEnoughIngredients(type)){
            Coffee coffee = createCoffee(type);
            if (coffee != null){
                coffee.makeCoffee();
                givesOutCoffee(coffee);
                orderingSystem.publicize(0, String.format("made %s", type));
            }else {
                orderingSystem.publicize(1, String.format("some problem with %s", type));
            }
        }else {
            orderingSystem.publicize(1, String.format("not enough ingredients for %s", type));
        }
    }

    private Coffee createCoffee(CoffeeType type){
        switch (type){
            case LATTE:
                int coffeeLatte = ingredients.takeCoffee(type.getCoffee());
                int milkLatte = ingredients.takeMilk(type.getMilk());
                int waterLatte = ingredients.takeWater(type.getWater());
                return new Latte(coffeeLatte, waterLatte, milkLatte);
            case AMERICANO:
                int coffeeAmericano = ingredients.takeCoffee(type.getCoffee());
                int waterAmericano = ingredients.takeWater(type.getWater());
                return new Americano(coffeeAmericano, waterAmericano);
            case MAROCCHINO:
                int coffeeMarocchino = ingredients.takeCoffee(type.getCoffee());
                int milkMarocchino = ingredients.takeMilk(type.getMilk());
                int waterMarocchino = ingredients.takeWater(type.getWater());
                int chocolateMarocchino = ingredients.takeChocolate(type.getChocolate());
                return new Marocchino(coffeeMarocchino, waterMarocchino, milkMarocchino, chocolateMarocchino);
            default:return null;
        }
    }

    private boolean checkEnoughIngredients(CoffeeType type){
        switch (type){
            case LATTE:return (type.getCoffee() <= ingredients.getCoffee()) && (type.getMilk() <= ingredients.getMilk())
                    && (type.getWater() <= ingredients.getWater());
            case AMERICANO:return (type.getCoffee() <= ingredients.getCoffee()) && (type.getWater() <= ingredients.getWater());
            case MAROCCHINO:return (type.getCoffee() <= ingredients.getCoffee()) && (type.getChocolate() <= ingredients.getChocolate())
                    && (type.getMilk() <= ingredients.getMilk()) && (type.getWater() <= ingredients.getWater());
            default:return false;
        }
    }

    private void givesOutCoffee(Coffee coffee){
        System.out.printf("take your %s", coffee.toString());
        //gives coffee to customer
    }
}
