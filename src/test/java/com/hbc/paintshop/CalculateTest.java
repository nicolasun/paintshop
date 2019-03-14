package com.hbc.paintshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hbc.paintshop.calculate.CalculateColor;

class CalculateTest {

	CalculateColor calculateColor = new CalculateColor();

	@Test
	@DisplayName("3C4C")
	void test3C4C() {
		String result = calculateColor.calculateColor("./src/test/testFiles/3C4C.txt");
		assertEquals("M M M", result, "3 color 4 customer");
	}

	@Test
	@DisplayName("5C3C-in requirement")
	void test5C3C() {
		String result = calculateColor.calculateColor("./src/test/testFiles/5C3C.txt");
		assertEquals("G G G G M", result, "5 color 3 customer");
	}
	
	@Test
	@DisplayName("1C2C-in requirement")
	void test1C2C() {
		String result = calculateColor.calculateColor("./src/test/testFiles/1C2C.txt");
		assertEquals("No solution exists", result, "1 color 2 customer");
	}
	
	@Test
	@DisplayName("5C14C-in requirement")
	void test5C14C() {
		String result = calculateColor.calculateColor("./src/test/testFiles/5C14C.txt");
		assertEquals("G M G M G", result, "5 color 14 customer");
	}
	
	@Test
	@DisplayName("2C2C-in requirement")
	void test2C2C() {
		String result = calculateColor.calculateColor("./src/test/testFiles/2C2C.txt");
		assertEquals("M M", result, "2 color 2 customer");
	}
	
	@Test
	@DisplayName("input test no color number in first line")
	void testInputValidNoColorNumber() {
		String result = calculateColor.calculateColor("./src/test/testFiles/InputValid_color_null.txt");
		System.out.println(result);
		assertEquals("For input string: \"\"", result, "input error no color number");
	}
	

}
