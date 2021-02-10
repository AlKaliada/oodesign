package org.kaliada;

public class CoffeeMaker {
    private IngredientsStorage ingredientsStorage;

    public CoffeeMaker() {
        ingredientsStorage = new IngredientsStorage();
    }

    public Coffee orderCoffee(CoffeeType type){
        if (checkEnoughIngredients(type)){
            Coffee coffee = createCoffee(type);
            if (coffee != null){
                coffee.makeCoffee();
                return coffee;
            }else {
                throw new UnsupportedOperationException("Problems with making coffee");
            }
        }else {
            throw new UnsupportedOperationException(String.format("No ingredients for %s", type));
        }
    }

    private Coffee createCoffee(CoffeeType type){
        switch (type){
            case LATTE:
                int coffeeLatte = ingredientsStorage.takeCoffee(type.getCoffee());
                int milkLatte = ingredientsStorage.takeMilk(type.getMilk());
                int waterLatte = ingredientsStorage.takeWater(type.getWater());
                return new Latte(coffeeLatte, waterLatte, milkLatte);
            case AMERICANO:
                int coffeeAmericano = ingredientsStorage.takeCoffee(type.getCoffee());
                int waterAmericano = ingredientsStorage.takeWater(type.getWater());
                return new Americano(coffeeAmericano, waterAmericano);
            case MAROCCHINO:
                int coffeeMarocchino = ingredientsStorage.takeCoffee(type.getCoffee());
                int milkMarocchino = ingredientsStorage.takeMilk(type.getMilk());
                int waterMarocchino = ingredientsStorage.takeWater(type.getWater());
                int chocolateMarocchino = ingredientsStorage.takeChocolate(type.getChocolate());
                return new Marocchino(coffeeMarocchino, waterMarocchino, milkMarocchino, chocolateMarocchino);
            default:return null;
        }
    }

    private boolean checkEnoughIngredients(CoffeeType type){
        switch (type){
            case LATTE:return (type.getCoffee() <= ingredientsStorage.getCoffee()) && (type.getMilk() <= ingredientsStorage.getMilk())
                    && (type.getWater() <= ingredientsStorage.getWater());
            case AMERICANO:return (type.getCoffee() <= ingredientsStorage.getCoffee()) && (type.getWater() <= ingredientsStorage.getWater());
            case MAROCCHINO:return (type.getCoffee() <= ingredientsStorage.getCoffee()) && (type.getChocolate() <= ingredientsStorage.getChocolate())
                    && (type.getMilk() <= ingredientsStorage.getMilk()) && (type.getWater() <= ingredientsStorage.getWater());
            default:return false;
        }
    }
}
