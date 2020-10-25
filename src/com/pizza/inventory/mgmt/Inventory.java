package com.pizza.inventory.mgmt;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Inventory extends Observable {
	private int value = 10;

	public Inventory() { }

	public void setValue(int value) {
		
		this.value = value;
		//System.out.println("Current count of Pizza in Inventory = "+value);
		setChanged();
		notifyObservers(value);
	}

	public int getValue() {
		return this.value;
	}
}
