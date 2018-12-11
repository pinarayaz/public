package ch.epfl.sweng.dp1.ex1;

import static ch.epfl.sweng.dp1.ex1.Pizza.PizzaType.*;

public class Main {

    public static Pizza orderPizza(Pizza.PizzaType type) {
        Pizza pizza;
        switch(type){
            case CLAM:
                pizza = Pizza.getClamPizza();
                break;
            case CHEESE:
                pizza = Pizza.getCheesePizza();
                break;
            case PEPPERONI:
                pizza = Pizza.getPepperoniPizza();
                break;
            case VEGGIE:
                pizza = Pizza.getVeggiePizza();
                break;
            default:
                pizza = null;
                break;
        }
        return pizza;
    }

    public static void main(String[] args){
        System.out.println(orderPizza(CHEESE).toString());
    }
}
