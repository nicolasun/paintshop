package com.hbc.paintshop;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hbc.paintshop.utilities.ReadInputFile;

class InputErrorTest {
	
	@Test
	@DisplayName("Input no color number error")
	void testNoColorNumber() {
		ReadInputFile inputFile = new ReadInputFile("./src/test/testFiles/InputValid_color_null.txt");
		Assertions.assertThrows(NumberFormatException.class, () -> {
			inputFile.readFromInputPath();
		  });
	}
	
	@Test
	@DisplayName("Input customer chosen color number error")
	void testNoCustomerChosenColorNumber() {
		ReadInputFile inputFile = new ReadInputFile("./src/test/testFiles/InputValid_customer_color_null.txt");
		Assertions.assertThrows(NumberFormatException.class, () -> {
			inputFile.readFromInputPath();
		  });
	}
	
	@Test
	@DisplayName("Input customer chosen color number out of range error")
	void testCustomerNumberOutOfRange() {
		ReadInputFile inputFile = new ReadInputFile("./src/test/testFiles/InputValid_customer_color_number_out_range.txt");
		Assertions.assertThrows(NumberFormatException.class, () -> {
			inputFile.readFromInputPath();
		  });
	}
	
	@Test
	@DisplayName("Input customer color attribute error")
	void testCustomerColorAttribute() {
		ReadInputFile inputFile = new ReadInputFile("./src/test/testFiles/InputValid_customer_color_attribute.txt");
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			inputFile.readFromInputPath();
		  });
	}
}
