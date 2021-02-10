package org.kaliada;

public class OrderingSystem {
    private CoffeeMaker coffeeMaker;
    private MoneyReceiver moneyReceiver;
    private double amount;
    private boolean readyForOrder;

    public OrderingSystem() {
        moneyReceiver = new MoneyReceiver();
        coffeeMaker = new CoffeeMaker();
        readyForOrder = true;
    }

    public void processOrder(CoffeeType selectedCoffee){
        if (!readyForOrder){
            return;
        }
        readyForOrder = false;
        amount = moneyReceiver.receiveMoney(selectedCoffee.getPrice());
        if (amount < selectedCoffee.getPrice()){
            moneyReceiver.returnMoney(amount);
            readyForOrder = true;
            return;
        }else if (amount > selectedCoffee.getPrice()){
            double change = amount - selectedCoffee.getPrice();
            moneyReceiver.returnMoney(change);
            amount -= change;
        }
        Coffee coffee;
        try{
            coffee = coffeeMaker.orderCoffee(selectedCoffee);
        }catch (UnsupportedOperationException e){
            readyForOrder = true;
            moneyReceiver.returnMoney(amount);
            return;
        }
        giveOutCoffee(coffee);
        readyForOrder = true;
    }

    private void giveOutCoffee(Coffee coffee){
        System.out.println(coffee.toString() + " is ready");
        //give coffee to customer
    }
}
