package com.hbc.paintshop.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.hbc.paintshop.data.*;
import static com.hbc.paintshop.data.Attribute.GLOSS;
import static com.hbc.paintshop.data.Attribute.MATTE;

public class ReadInputFile {

	private String inputPath;
	
	private PaintCustomer paintCustomer = new PaintCustomer();
	
	public ReadInputFile(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public void readFromInputPath() throws IOException, NumberFormatException, NoSuchElementException{
		try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
			String line = null;
			Boolean firstLine = true;
			int colorNumber = 0;
			while ((line = br.readLine()) != null) {
				if (firstLine) {
					//read color number 
					colorNumber = Integer.parseInt(line.trim());
					if(colorNumber > 0) {
						this.paintCustomer.setColorNumber(colorNumber);
					}
					else {
						throw new NumberFormatException("the color number is incorrect");
					}
					firstLine = false;
				} else {
					//add customer to customer list
					this.paintCustomer.addCustomer(this.readLineToCustomer(line.trim()));
				}
			}
		}
	};
	
	private Customer readLineToCustomer(String line) throws NumberFormatException,NoSuchElementException  {
		
		//check null
		if (line == null || line.equals("")) {
			return null;
		}

		Customer customer = new Customer();

        // split the string by ' ' space into a string list
		// 1 G 2 M
		// 2 elements to be a color cell
		String[] colorList = line.split(" ");
		for (int i = 0; i < colorList.length; i+=2) {

			Integer color = Integer.parseInt(colorList[i]);
			if((color > this.paintCustomer.getColorNumber())||(color < 1)) {
				throw new NumberFormatException("the customer chosen color number is incorrect");
			}
			String attribute = colorList[i+1];
			if(attribute.equals(MATTE)||attribute.equals(GLOSS)) {
				customer.addColor(color, attribute);
			}
			else {
				throw new NoSuchElementException("attribute is invalid! the wrong attribute is"+attribute);
			}
			
		}

		return customer;
	}
	
	public PaintCustomer getPaintCustomer() {
		return this.paintCustomer;
	}
}
