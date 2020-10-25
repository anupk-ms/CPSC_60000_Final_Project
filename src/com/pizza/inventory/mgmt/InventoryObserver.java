package com.pizza.inventory.mgmt;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class InventoryObserver implements Observer {

	private int value;
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
		//System.out.println(arg);
		this.value = (int) arg;
		//display();
		if (o instanceof Inventory) {
			Inventory updatedInventory = (Inventory) o;
			if(updatedInventory.getValue()< 10) {
				Scanner in = new Scanner(System.in); 
				
				System.out.println("---------------------  ALERT ------------------------");
				System.out.println("Inventory has less only "+updatedInventory.getValue()+" pizza left need at least 10");
				System.out.println("------------------------------------------------------");
				System.out.println("Want to load up inventory now: [y/n] ");
				String response = in.nextLine();
				if(response.equalsIgnoreCase("Y")) {
					System.out.println("How many Pizza to load (by default will make to 10):");
					response = in.nextLine();
					if(response.equals("") || null == response) {
						
						System.out.println("Loading new stock of "+ (10-updatedInventory.getValue())+" Pizzas");
						((Inventory) o).setValue(10 + updatedInventory.getValue());
						//System.out.println("Inventory have =" +updatedInventory.getValue()+" pizzas");
					}
					else {
						((Inventory) o).setValue(Integer.parseInt(response)+updatedInventory.getValue());
						System.out.println("Inventory is loaded to "+((Inventory) o).getValue()+" Pizzas");
					}
				}
			}
			this.value = updatedInventory.getValue();
			//display();
		}
	}
}
