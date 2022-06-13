package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 0)
	public void firstTest() {
		System.out.println("firstTest method");
	}

	@Test(priority = 1)
	public void secondTest() {
	System.out.println("secondTest method");
	}
	
	@Test(priority = 2)
	public void thirdTest() {
		System.out.println("thirdTest method");
	}

	@Test(priority = 3)
	public void fourthTest() {
		System.out.println("fourthTest method");
	}
}