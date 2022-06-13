package com.neotech.lesson02;

public class EnableAndDisable {

	@Test(priority = 0)
	public void firstTest() {
		System.out.println("firstTest Method");
	}

	@Test(enabled = false, priority = 1) // to skip test
	public void secondTest() {
		System.out.println("secondTest Method");
	}

	@Test(priority = 2)
	public void thirdTest() {
		System.out.println("thirdTest Method");
	}

	@Test(priority = 3)
	public void fourthTest() {
		System.out.println("fourthTest Method");
	}
}
