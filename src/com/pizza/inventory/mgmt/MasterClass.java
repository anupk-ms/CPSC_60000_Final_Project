/**
 * 
 */
package com.pizza.inventory.mgmt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Anupk
 *
 */
public class MasterClass {
	static HashMap<Integer, String> codeMap = new HashMap<Integer, String>();
	static HashMap<String, Integer> order = new HashMap<String, Integer>();
	static BaseCommand command = null;

	/**
	 * @param args
	 */
	private static void printMenu(Iterator iterator) {
		int i = 1;
		while (iterator.hasNext()) {
			String menuItem = (String) iterator.next();
			codeMap.put(i, menuItem);
			System.out.println("    " + i + "     " + menuItem);
			i++;
		}
	}

	public static void countFreq(String arr[], int n) {
		boolean visited[] = new boolean[n];
		order.clear();
		Arrays.fill(visited, false);

		// Traverse through array elements and
		// count frequencies
		for (int i = 0; i < n; i++) {
			// Skip this element if already processed
			if (visited[i] == true)
				continue;
			// Count frequency
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i].equals(arr[j])) {
					visited[j] = true;
					count++;
				}
			}
			// System.out.println(arr[i] + " " + count);
			order.put(arr[i], count);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Inventory inventory = new Inventory();
		//InventoryObserver inventoryObserver = new InventoryObserver(inventory);
		// inventory.setValue(80);

		/*
		 * int a = in.nextInt(); System.out.println("You entered integer "+a);
		 * 
		 * float b = in.nextFloat(); System.out.println("You entered float "+b);
		 */

		PizzaMenu pizzaMenu = new PizzaMenu();
		// with no iterators
		System.out.println("\nMENU\n----\nThe lovely PIZZAs at our PZZATERIA ");

		// with iterators
		Iterator pizzaIterator = pizzaMenu.createIterator();
		System.out.println("___________________________");
		System.out.println(" | Code |  Pizza Name    |");
		System.out.println("_|______|________________|_");
		printMenu(pizzaIterator);

		System.out.println("Want to order pizza today : [y/n]");
		String response = in.nextLine();
		response = enterAgainIfBlank(in, response);
		if (response.equalsIgnoreCase("Y")) {
			while (response.equalsIgnoreCase("Y")) {
				newOrder(in, inventory);
				System.out.println("Want to proceed with new order : [y/n]");
				response = in.nextLine();
				response = enterAgainIfBlank(in, response);
			}
		}
	}

	private static String enterAgainIfBlank(Scanner in, String response) {
		while (response.equals("") || null == response) {
			System.out.println("Please enter a valid value ");
			response = in.nextLine();
		}
		return response;
	}
	private static String enterAgainIfNotDigit(Scanner in, String response) {
		
		while (!Character.isDigit(response.charAt(0))) {
			System.out.println("Please enter a valid value ");
			response = in.nextLine();
		}
		return response;
	}

	private static void newOrder(Scanner in, Inventory inventory) {
		int pizzacount = 0;

		System.out.println(" \nHow many pizza to order : ");
		String response = in.nextLine();
		response = enterAgainIfBlank(in, response);

		pizzacount = Integer.parseInt(enterAgainIfNotDigit(in, response));

		String[] orderCurr = new String[pizzacount];

		for (int i = 0; i < pizzacount; i++) {
			System.out.println("Please enter type code for choice of Pizza " + i + ": ");
			String pizzaCode = in.nextLine();
			pizzaCode=enterAgainIfBlank(in, pizzaCode);
			pizzaCode=enterAgainIfNotDigit(in, pizzaCode);
			while (!codeMap.containsKey(Integer.parseInt(pizzaCode))) {
				System.out.println("Not a valid code");
				//System.out.println(" \nPlease enter type code for choice of Pizza " + i + ": ");
				pizzaCode = in.nextLine();
				pizzaCode=enterAgainIfNotDigit(in, pizzaCode);
			}
			orderCurr[i] = codeMap.get(Integer.parseInt(pizzaCode));

		}
		countFreq(orderCurr, orderCurr.length);
		System.out.println("________________________________________________________");
		System.out.println("To confirm you have ordered total " + pizzacount + " pizzas");

		for (String key : order.keySet()) {
			System.out.println(order.get(key) + " " + key);
		}
		System.out.println("________________________________________________________");
		System.out.println("");

		// TODO place order & update Inventory
		System.out.println("Want to confirm order : [y/n]");
		response = in.nextLine();
		response = enterAgainIfBlank(in, response);
		if (response.equalsIgnoreCase("Y")) {
			placeOrder(in,inventory, pizzacount);
		}
	}
	
	private static void placeOrder(Scanner in,Inventory inventory, int pizzacount) {
		PizzaFactory factory = new PizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		
		/*Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);*/
		
		// TODO check if enough in Inventory
		if (inventory.getValue() > pizzacount) {
			for (String key : order.keySet()) {
				Pizza pizza = store.orderPizza(key);
				
				System.out.println(pizza.toString()+"\n\nReady "+pizza.getName());
			}
			System.out.println("---------- Order Plaved Successfully ---------");
			inventory.setValue(inventory.getValue() - pizzacount);
			command = Operations.getCommand("CheckInventory");
			command.execute(in,inventory);
			// checkInventory(in, inventory);

		} else {
			command = Operations.getCommand("alertNupdate");
			command.execute(in,inventory);
			// alertNupdate(in, inventory);
		}
	}
	/*
	 * private static void checkInventory(Scanner in, Inventory inventory) { String
	 * response; System.out.println("Want to Check inventory : [y/n]"); response =
	 * in.nextLine(); if (response.equalsIgnoreCase("Y")) {
	 * System.out.println("Current count of Pizza in Inventory = " +
	 * inventory.getValue()); } }
	 * 
	 * private static void alertNupdate(Scanner in, Inventory inventory) { String
	 * response;
	 * System.out.println("---------------------  ALERT ------------------------");
	 * System.out.println("Inventory has less only " + inventory.getValue() +
	 * " pizza left unable to place oder");
	 * System.out.println("------------------------------------------------------");
	 * System.out.println(" \nPlease load up inventory : [y/n] ");
	 * 
	 * // TODO stock up Inventory
	 * System.out.println("How many Pizza to load (by default will make to 10):");
	 * response = in.nextLine(); if (response.equals("") || null == response) {
	 * inventory.setValue(10); System.out.println("\n Loading new stock of =" + (10
	 * - inventory.getValue()) + " Pizzas"); } else {
	 * inventory.setValue(Integer.parseInt(response));
	 * System.out.println("Inventory is loaded to " + inventory.getValue() +
	 * " Pizzas"); } }
	 */
}
