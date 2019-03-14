package com.hbc.paintshop.data;

import java.util.ArrayList;

public class PaintCustomer {

	private int colorNumber;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public int getColorNumber() {
		return colorNumber;
	}

	public void setColorNumber(int colorNumber) {
		this.colorNumber = colorNumber;
	}
	
	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}
	
	public ArrayList<Customer> getCustomerList(){
		return this.customerList;
	}
	
	
}
