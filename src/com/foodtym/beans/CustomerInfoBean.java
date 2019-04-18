package com.foodtym.beans;

public class CustomerInfoBean {
	private Customer customer;
	private Location location;
	private Cart cart;
	private boolean customerLoggedIn;
	
	public boolean isCustomerLoggedIn() {
		return customerLoggedIn;
	}

	public void setCustomerLoggedIn(boolean customerLoggedIn) {
		this.customerLoggedIn = customerLoggedIn;
		if (this.customer != null)
			this.customerLoggedIn = true;
		else
			this.customerLoggedIn = false;
	}

	public CustomerInfoBean() {
		customerLoggedIn = false;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
		if (this.customer != null)
			this.customerLoggedIn = true;
		else
			this.customerLoggedIn = false;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CustomerInfoBean [customer=" + customer + ", location=" + location + ", cart=" + cart
				+ ", customerLoggedIn=" + customerLoggedIn + "]";
	}
	
}
