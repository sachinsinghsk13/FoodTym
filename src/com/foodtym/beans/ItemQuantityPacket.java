package com.foodtym.beans;

public class ItemQuantityPacket {
	private String name;
	private int itemId;
	private double unitprice;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return unitprice;
	}
	public void setPrice(double price) {
		this.unitprice = price;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void increseQuantity() {
		this.quantity++;
	}
	
	public void decreseQuantity() {
		if (quantity > 0)
			this.quantity--;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemQuantityPacket && ((ItemQuantityPacket) obj).itemId == this.itemId)
			return true;
		return false;
	}
	
	
}
