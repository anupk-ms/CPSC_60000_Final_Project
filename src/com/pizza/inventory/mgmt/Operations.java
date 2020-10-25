package com.pizza.inventory.mgmt;

public class Operations {

	public static BaseCommand getCommand(String string) {
		// TODO Auto-generated method stub
		switch(string) {
		  case "CheckInventory":
			  return CheckInventoryCommand.singleton();
		  case "alertNupdate":
		    // code block
			  return AlertAndUpdateCommand.singleton();
		   
		  default:
		    break;
		}
		return null;
		
	}
}
