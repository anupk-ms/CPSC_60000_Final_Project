package com.pizza.inventory.mgmt;

import java.util.Scanner;

public class AlertAndUpdateCommand extends BaseCommand{

	private static AlertAndUpdateCommand instance = new AlertAndUpdateCommand();
	private AlertAndUpdateCommand() {

	}

	public static AlertAndUpdateCommand singleton() {
		return instance;
	}

	@Override
	public void execute( Scanner in,Inventory inventory) {
		//Scanner in = new Scanner(System.in);
		String response;
		System.out.println("---------------------  ALERT ------------------------");
		System.out.println("Inventory has less only " + inventory.getValue() + " pizza left unable to place oder");
		System.out.println("------------------------------------------------------");
		System.out.println(" \nPlease load up inventory : [y/n] ");
		
		// TODO stock up Inventory
		System.out.println("How many Pizza to load (by default will make to 10):");
		response = in.nextLine();
		if (response.equals("") || null == response) {
			inventory.setValue(10);
			System.out.println("\n Loading new stock of =" + (10 - inventory.getValue()) + " Pizzas");
		} else {
			inventory.setValue(Integer.parseInt(response));
			System.out.println("Inventory is loaded to " + inventory.getValue() + " Pizzas");
		}
		//in.close();
	}
}
