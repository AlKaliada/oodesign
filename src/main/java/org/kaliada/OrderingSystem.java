package org.kaliada;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderingSystem {
    private static final Logger LOGGER = LogManager.getLogger();
    private CoffeeMachine coffeeMachine;
    private MoneyReceiver moneyReceiver;
    private double amount;
    private CoffeeType selectedCoffee;

    public OrderingSystem() {
        moneyReceiver = new MoneyReceiver();
        coffeeMachine = new CoffeeMachine(this);
    }

    public void selectCoffee(CoffeeType selectedCoffee){
        amount = moneyReceiver.receiveMoney(selectedCoffee.getPrice());
        this.selectedCoffee = selectedCoffee;
        coffeeMachine.orderCoffee(selectedCoffee);
    }

    public void publicize(int priority, String message){
        if (priority == 0){
            LOGGER.log(Level.TRACE, message) ;
        }else {
            moneyReceiver.returnMoney(amount);
            LOGGER.log(Level.WARN, message);
        }
    }
}
