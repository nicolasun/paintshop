package com.hbc.paintshop.data;

import java.util.HashMap;

public class Customer {

	private HashMap<Integer, String> colorList = new HashMap<Integer, String>();
	
	public boolean addColor(Integer color, String attribute) {
		//check duplicate key in the input
		if(null==this.colorList.put(color,attribute))return true;
		return false;
	}
	
	public Integer getColorListSize() {
		return this.colorList.size();
	}
	
	public HashMap<Integer, String> getColorList(){
		return this.colorList;
	}
	
}
