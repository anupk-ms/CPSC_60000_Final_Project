package com.pizza.inventory.mgmt;

public class PizzaFactory {
	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("Cheese Pizza")) {
			pizza = new CheesePizza();
		} else if (type.equals("Pepperoni Pizza")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("Clam Pizza")) {
			pizza = new ClamPizza();
		} else if (type.equals("Veggie Pizza")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
}
