package org.kaliada;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CoffeeType latte = CoffeeType.LATTE;
        OrderingSystem orderingSystem = new OrderingSystem();
        orderingSystem.processOrder(latte);
    }
}
