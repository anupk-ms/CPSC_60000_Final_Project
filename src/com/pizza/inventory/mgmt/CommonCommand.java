package com.pizza.inventory.mgmt;

import java.util.Scanner;

public interface CommonCommand {
	public void execute(Scanner in, Inventory inventory);
}