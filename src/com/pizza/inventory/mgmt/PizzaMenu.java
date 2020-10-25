package com.pizza.inventory.mgmt;

public class PizzaMenu {
	static final int MAX_ITEMS = 4;
	int numberOfItems = 0;
	String[] menuItems;
  
	public PizzaMenu() {
		menuItems = new String[MAX_ITEMS];
 
		addItem("Veggie Pizza");
		addItem("Cheese Pizza");
		addItem("Clam Pizza");
		addItem("Pepperoni Pizza ");
		//addItem("Steamed Veggies and Brown Rice");
		//addItem("Pasta");
	}
  
	public void addItem(String name) 
	{
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full!  Can't add item to menu");
		} else {
			menuItems[numberOfItems] = name;
			numberOfItems = numberOfItems + 1;
		}
	}
 
	public String[] getMenuItems() {
		return menuItems;
	}
  
	public Iterator createIterator() {
		return new PizzaMenuIterator(menuItems);
	}
 
	public String toString() {
		return "Pizza Menu";
	}
	// other menu methods here
}
