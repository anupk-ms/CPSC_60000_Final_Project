package com.pizza.inventory.mgmt;

import java.util.Scanner;

public class Helper {
	public static String enterAgainIfBlank(Scanner in, String response) {
		while (response.equals("") || null == response) {
			System.out.println("Please enter a valid value ");
			response = in.nextLine();
		}
		return response;
	}
	public  static String enterAgainIfNotDigit(Scanner in, String response) {
		
		while (!Character.isDigit(response.charAt(0))) {
			System.out.println("Please enter a valid value ");
			response = in.nextLine();
		}
		return response;
	}
}
