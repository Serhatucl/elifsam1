package com.neotech.lesson02;


import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utill.BaseClass;
import com.neotech.utill.CommonMethods;

import dev.failsafe.internal.util.Assert;

public class AssertDemo extends BaseClass{

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	
	@Test(enabled = false)
	public void titleValidation() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
		System.out.println("Test after assertion.");
	}
	
	@Test
	public void validationLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class'orangehrm-logo']/img"));
		boolean logoDisplayed = logo.isDisplayed();
		
		//1st way
		//Assert.assertEquals(logoDisplayed,true);
		
		//2nd way
		Assert.assertEquals(logoDisplayed, true, "Logo is not displayed");
	}
}
