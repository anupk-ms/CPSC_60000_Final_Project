package com.pizza.inventory.mgmt;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class InventoryObserver implements Observer {

	private int value;
	public int getValue() {
		return value;
	}

	private Observable observable;

	public InventoryObserver(Observable observable) {
		this.observable = observable;
		observable.addObserver((Observer) this);
	}

	public void display() {
		System.out.println("Total Pizza in Inventory" + value);
	}

	@Override
	public void update(Observable o, Object arg) {
		// System.out.println(arg);
		this.value = (int) arg;
		// display();
		if (o instanceof Inventory) {
			Inventory updatedInventory = (Inventory) o;
			if (updatedInventory.getValue() < 10) {
				Scanner in = new Scanner(System.in);
				BaseCommand command = Operations.getCommand("alertNupdate");
				command.execute(in, updatedInventory);
			}
			this.value = updatedInventory.getValue();
		}
	}
}
