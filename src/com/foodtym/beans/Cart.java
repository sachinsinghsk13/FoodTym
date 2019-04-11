package com.foodtym.beans;

public interface Cart {
	void addItem(ItemQuantityPacket item);
	ItemQuantityPacket getItem(int itemId);
	void removeItem(int itemId);
	int getTotalItems();
	double totalPrice();
}
