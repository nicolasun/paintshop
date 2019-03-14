package com.hbc.paintshop.calculate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.hbc.paintshop.data.Customer;
import com.hbc.paintshop.utilities.ReadInputFile;
import static com.hbc.paintshop.data.Attribute.GLOSS;

public class CalculateColor {
	
	public final static String NO_SOLUTION_EXISTS = "No solution exists";
	
	private String[] solution;
	private boolean noSolution = false;
	private boolean nextCustomer;

	public String calculateColor(String inPath) {
		
		//read file into files
		ArrayList<Customer> customerList = null;
		Integer colorNumber = 0;
		try {
			ReadInputFile readFile = new ReadInputFile(inPath);
			readFile.readFromInputPath();
			customerList = readFile.getPaintCustomer().getCustomerList();
			colorNumber = readFile.getPaintCustomer().getColorNumber();
		}
		catch(IOException | NumberFormatException | NoSuchElementException e) {
			return e.getMessage();
		}
		//get customer list


		this.solution = new String[colorNumber];

		ArrayList<Customer> treatedCustomerList = customerList;
		//loop all
		boolean check = true;
		while(check){
			//sort customer list
			treatedCustomerList.sort(
					(c1,c2)->c1.getColorListSize().compareTo(c2.getColorListSize())
					);
			// stop by sorted first customer chose more than 2 colors
			if(treatedCustomerList.get(0).getColorListSize() >= 2) {
				return solutionToString();
			}
			
			treatedCustomerList = this.calculateCustomer(treatedCustomerList);
			//no solution
			if(null==treatedCustomerList) {
				return NO_SOLUTION_EXISTS;
			}
			//if no customer in the list 
			if(treatedCustomerList.size() == 0) {
				return solutionToString();
			}
		}
		return NO_SOLUTION_EXISTS;
		
	}
	
	//do not user recursive
	private ArrayList<Customer> calculateCustomer(ArrayList<Customer> customerList) {
		//the customerList must be sorted before calculating
		ArrayList<Customer> nextCustomerList = new ArrayList<Customer>();
		for (Customer customer : customerList) {
			// check color size
			if (customer.getColorListSize() == 1) {
				// customer only choose 1 color
				// check the color attribute is set or not		
				customer
					.getColorList()
					.forEach((k, v) -> {
						if (solution[k-1]==null) {
							solution[k-1] = v;
						} else {
							if (!solution[k-1].equals(v)) {
								this.noSolution = true;
							}
						}
					});
				if(this.noSolution) {
					return null;
				}
			} else {
				// we need rebuild a temporary customer
				this.nextCustomer = false;
				Customer customerTemp = new Customer();
				customer.getColorList().forEach((k, v) -> {
					if (solution[k-1]==null) {
						customerTemp.addColor(k, v);
					} else {
						if (solution[k-1].equals(v)) {
							// next customer
							this.nextCustomer = true;
						}
						// ignore no equals
					}
				});
				if(this.nextCustomer == true) {
					continue;
				}
				if (customerTemp.getColorListSize() == 0) {
					// no solution
					return null;
				}
				//add new customer to new customer list
				nextCustomerList.add(customerTemp);
			}
		}
		return nextCustomerList;
	}
	
	
	private String solutionToString() {
		//replace null to G
		for(int i=0;i<this.solution.length; i++ ) {
			if(this.solution[i]==null) {
				this.solution[i] = GLOSS;
			}
		}
		//to string
		return String.join(" ", this.solution);
	}
	
}
