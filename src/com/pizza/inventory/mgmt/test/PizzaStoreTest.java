package com.pizza.inventory.mgmt.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pizza.inventory.mgmt.CheesePizza;
import com.pizza.inventory.mgmt.ClamPizza;
import com.pizza.inventory.mgmt.PepperoniPizza;
import com.pizza.inventory.mgmt.PizzaFactory;
import com.pizza.inventory.mgmt.PizzaStore;
import com.pizza.inventory.mgmt.VeggiePizza;
 
public class PizzaStoreTest {
 
	 private PizzaStore aPizzaStore;
	  
		
	   @Before
	   public void setUp() throws Exception 
	   {
		   PizzaFactory factory = new PizzaFactory();
		   aPizzaStore =  new PizzaStore(factory);
	   }
	   
	   @Test
	   public void testCreatePizza1() 
	   {
	      assertEquals((aPizzaStore.orderPizza("Cheese Pizza")).getName(),"Cheese Pizza");
	      assertEquals((aPizzaStore.orderPizza("Cheese Pizza")).toString(),(new CheesePizza()).toString());
	   }
	   @Test
	   public void testCreatePizza2() 
	   {
	      assertEquals((aPizzaStore.orderPizza("Pepperoni Pizza")).getName(),"Pepperoni Pizza");
	      assertEquals((aPizzaStore.orderPizza("Pepperoni Pizza")).toString(),(new PepperoniPizza()).toString());
	   }
	   @Test
	   public void testCreatePizza3() 
	   {
	      assertEquals((aPizzaStore.orderPizza("Clam Pizza")).getName(),"Clam Pizza");
	      assertEquals((aPizzaStore.orderPizza("Clam Pizza")).toString(),(new ClamPizza()).toString());
	   }
	   @Test
	   public void testCreatePizza4() 
	   {
	      assertEquals((aPizzaStore.orderPizza("Veggie Pizza")).getName(),"Veggie Pizza");
	      assertEquals((aPizzaStore.orderPizza("Veggie Pizza")).toString(),(new VeggiePizza()).toString());
	   }		
}
