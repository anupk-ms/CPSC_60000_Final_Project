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
		String response=null;
		if(inventory.getValue()<10) {
		System.out.println("---------------------  ALERT ------------------------");
		System.out.println("Inventory has less only " + inventory.getValue() + " pizza left in inventory");
		System.out.println("------------------------------------------------------");
		
		}
		System.out.println(" \nWant to load up inventory now [y/n]");
		response = in.nextLine();
		response = Helper.enterAgainIfBlank(in, response);
		if (response.equalsIgnoreCase("Y")){
			// TODO stock up Inventory
			System.out.println("How many Pizza to load (by default will make to 10):");
			response = in.nextLine();
			if (response.equals("") || null == response) {
				System.out.println("\n Loading new stock of =" + (10 - inventory.getValue()) + " Pizzas");
				inventory.setValue(10);
			} else {
				inventory.setValue(Integer.parseInt(response) + inventory.getValue());
				System.out.println("Inventory is loaded to " + inventory.getValue() + " Pizzas");
			}
			//in.close();
		}
	}
}
