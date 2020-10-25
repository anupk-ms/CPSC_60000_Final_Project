package com.pizza.inventory.mgmt;

import java.util.Scanner;

public class CheckInventoryCommand extends BaseCommand{
	//@extends 
	//BaseCommand{

		private static CheckInventoryCommand instance = new CheckInventoryCommand();
		private CheckInventoryCommand() {

		}

		public static CheckInventoryCommand singleton() {
			return instance;
		}

		public void execute(Scanner in,Inventory inventory) {
			//Scanner in = new Scanner(System.in);
			String response;
			System.out.println("Want to Check inventory : [y/n]");
			response = in.nextLine();
			while(response.equals("") || null == response) {
				System.out.println("Please enter a valid value either 'Y' or 'N'");
				response = in.nextLine();
			}
			if (response.equalsIgnoreCase("Y")) {
				System.out.println("Current count of Pizza in Inventory = " + inventory.getValue());
			}
			//in.close();
		}
}
