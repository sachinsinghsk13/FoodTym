package com.foodtym.beans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FoodCart implements Cart {
	private int totalItems;
	
	private Set<ItemQuantityPacket> cartItems;
	public FoodCart() {
		cartItems = new HashSet<>();
	}
	
	@Override
	public void addItem(ItemQuantityPacket item) {
		cartItems.add(item);
	}

	@Override
	public ItemQuantityPacket getItem(int itemId) {
		Iterator<ItemQuantityPacket> iterator = cartItems.iterator();
		while(iterator.hasNext()) {
			ItemQuantityPacket itemPacket = iterator.next();
			if (itemPacket.getItemId() == itemId)
				return itemPacket;
		}
		return null;
	}

	@Override
	public void removeItem(int itemId) {
		Iterator<ItemQuantityPacket> iterator = cartItems.iterator();
		while(iterator.hasNext()) {
			ItemQuantityPacket itemPacket = iterator.next();
			if (itemPacket.getItemId() == itemId) {
				cartItems.remove(itemPacket);
				break;
			}
		}

	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = cartItems.size();
	}

	@Override
	public double totalPrice() {
		double totalPrice = 0.0;
		Iterator<ItemQuantityPacket> items = cartItems.iterator();
		while (items.hasNext()) {
			totalPrice += items.next().getPrice();
		}
		return totalPrice;
	}

}
