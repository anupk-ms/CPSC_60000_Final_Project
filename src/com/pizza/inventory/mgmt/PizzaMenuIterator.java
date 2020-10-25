package com.pizza.inventory.mgmt;

public class PizzaMenuIterator implements Iterator {


		String[] items;
		int position = 0;
	 
		public PizzaMenuIterator(String[] items) {
			this.items = items;
		}
	 
		public String next() {
			String menuItem = items[position];
			position = position + 1;
			return menuItem;
		}
	 
		public boolean hasNext() {
			if (position >= items.length || items[position] == null) {
				return false;
			} else {
				return true;
			}
		}
	}


