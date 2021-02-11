package org.kaliada;

public class OrderingSystem {
    private CoffeeMaker coffeeMaker;
    private MoneyReceiver moneyReceiver;
    private double amountAcceptedMoney;
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
        amountAcceptedMoney = moneyReceiver.receiveMoney(selectedCoffee.getPrice());
        if (amountAcceptedMoney < selectedCoffee.getPrice()){
            moneyReceiver.returnMoney(amountAcceptedMoney);
            readyForOrder = true;
            return;
        }else if (amountAcceptedMoney > selectedCoffee.getPrice()){
            double change = amountAcceptedMoney - selectedCoffee.getPrice();
            moneyReceiver.returnMoney(change);
            amountAcceptedMoney -= change;
        }
        Coffee coffee;
        try{
            coffee = coffeeMaker.orderCoffee(selectedCoffee);
        }catch (IllegalArgumentException e){
            readyForOrder = true;
            moneyReceiver.returnMoney(amountAcceptedMoney);
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
