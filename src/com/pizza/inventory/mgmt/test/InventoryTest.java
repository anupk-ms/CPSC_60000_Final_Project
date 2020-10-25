package com.pizza.inventory.mgmt.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pizza.inventory.mgmt.Inventory;
import com.pizza.inventory.mgmt.InventoryObserver;
 
public class InventoryTest {
 
	 private Inventory inventory;
	 private InventoryObserver inventoryObserver;
	  
		
	   @Before
	   public void setUp() throws Exception 
	   {
		   inventory = new Inventory();
		   inventoryObserver = new InventoryObserver(inventory);
	   }
	   
	   @Test
	   public void testSetValue1() 
	   {
		  inventory.setValue(10);
	      assertEquals(inventoryObserver.getValue(),10);
	      assertEquals(inventory.getValue(),10);
	   }
	   @Test
	   public void testSetValue2() 
	   {
		  inventory.setValue(50);
	      assertEquals(inventoryObserver.getValue(),50);
	      assertEquals(inventory.getValue(),50);
	   }
	   @Test
	   public void testSetValue3() 
	   {
		  inventory.setValue(100);
	      assertEquals(inventoryObserver.getValue(),100);
	      assertEquals(inventory.getValue(),100);
	   }	 
}
