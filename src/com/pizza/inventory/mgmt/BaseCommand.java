package com.pizza.inventory.mgmt;
import java.util.Scanner;

public abstract class BaseCommand implements CommonCommand {
	public abstract void execute(Scanner in,Inventory inventory);
}