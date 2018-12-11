package ch.epfl.sweng.dp1.ex1;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;

abstract public class Pizza {
	enum PizzaType{
		CHEESE,
		CLAM,
		PEPPERONI,
		VEGGIE
	}

	protected String name;
	protected String dough;
	protected String sauce;
	protected ArrayList<String> toppings = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
	}

	public void bake() {
		System.out.println("Baking " + name);
	}

	public void cut() {
		System.out.println("Cutting " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}

	public static Pizza getCheesePizza(){
		Pizza pizza = new CheesePizza();
		pizza.prepare();
		return pizza;
	}

	public static Pizza getClamPizza(){
		Pizza pizza = new ClamPizza();
		pizza.prepare();
		return pizza;
	}

	public static Pizza getPepperoniPizza(){
		Pizza pizza = new PepperoniPizza();
		pizza.prepare();
		return pizza;
	}

	public static Pizza getVeggiePizza(){
		Pizza pizza = new VeggiePizza();
		pizza.prepare();
		return pizza;
	}

	private void preparePizza(){
		prepare();
		bake();
		cut();
		box();
	}

	public String toString() {
		// code to display pizza name and ingredients
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (String topping : toppings) {
			display.append(topping + "\n");
		}
		return display.toString();
	}
}

