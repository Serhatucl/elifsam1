package com.neotech.utill;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

	
		public static void sendText(WebElement element, String text) {
			
			element.clear();
			element.sendKeys(text);
		}

		public static void clickRadioOrCheckbox (List<WebElement> listElement, String value) {
			
			String actualValue;

			for (WebElement el : listElement) {
				actualValue = el.getAttribute("value").trim();

				if (actualValue.equals(value) && el.isEnabled()) {
					el.click();
					break;
				}
			}
		}

		public static void wait(int seconds) {

			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		public static void selectDropdown(WebElement element, String visibleText) {

			try {

				Select sl = new Select(element);

				List<WebElement> options = sl.getOptions();

				for (WebElement el : options) {

					if (el.getText().contains(visibleText)) {
						sl.selectByVisibleText(visibleText);
						break;
					}
				}

			} catch (UnexpectedTagNameException e) {

				e.printStackTrace();
			}
		}

		public static void selectDropdown(WebElement element, int index) {
			
			try {
				Select select = new Select(element);

				int size = select.getOptions().size();

				if (size > index) {
					
					select.selectByIndex(index);
				}
			} catch (UnexpectedTagNameException e) {

				e.printStackTrace();
			}
		}


		public static void acceptAlert() {

			try {
				
				Alert alert = driver.switchTo().alert();
				alert.accept();

			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}

		public static void dismissAlert() {

			try {
				Alert al = driver.switchTo().alert();
				al.dismiss();
				
			} catch (NoAlertPresentException e) {
				
				e.printStackTrace();

			}
		}

		public static String getAlertText() {

			String alertText = null;

			try {

				Alert alert = driver.switchTo().alert();
				
				alertText = alert.getText();

			} catch (NoAlertPresentException e) {
				
				e.printStackTrace();
			}
			
			return alertText;
		}

		public static void sendAlertText(String text) {
			
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(text);
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
		
		public static void switchToFrame(String nameOrId) {
			
			try {
			driver.switchTo().frame(nameOrId);
			
			}catch(NoSuchFrameException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void switchToFrame(int index) {
			
			try {
				
			driver.switchTo().frame(index);
			
			}catch(NoSuchFrameException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void switchToFrame(WebElement element) {
			
			try {
				
			driver.switchTo().frame(element);
			
			}catch(NoSuchFrameException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void switchToChildWindow() {
			
			String mainWindow = driver.getWindowHandle();
			
			Set<String> windows = driver.getWindowHandles();
			
			
			
			for(String window : windows) {
				
				if(!window.equals(mainWindow)) {
					driver.switchTo().window(window);
				}
			}
		}
		
		
		public static WebDriverWait getWaitObject(){
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
			
			return wait;
		}
		
		public static WebElement waitForClickability(WebElement element) {
			
			//create a wait object and than add the expected wait conditions
			
			return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
			
		}
		
		public static WebElement waitForVisibility(WebElement element) {
			
			return getWaitObject().until(ExpectedConditions.visibilityOf(element));
		}
		
		public static void click(WebElement element) {
			
			waitForClickability(element);
			element.click();
		}
		
		/**
		 * This method casts the driver to JavascriptExecutor and returns it
		 * 
		 * @return JavascriptExecutor
		 */
		public static JavascriptExecutor getJSObject() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js;

			// in one step
			// return (JavascriptExecutor) driver;
		}

		/**
		 * This method will click to the element that is passed using JavascriptExecutor
		 * 
		 * @param element
		 */
		public static void jsClick(WebElement element) {
			getJSObject().executeScript("arguments[0].click();", element);
		}

		/**
		 * This method will scroll the page until the element that is passed becomes
		 * visible
		 * 
		 * @param element
		 */
		public static void scrollToElement(WebElement element) {
			getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
		}

		/**
		 * This method will scroll the page down based on the passed pixel parameter
		 * 
		 * @param pixel
		 */
		public static void scrollDown(int pixel) {
			getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
		}

		/**
		 * This method will scroll the page up based on the passed pixel parameter
		 * 
		 * @param pixel
		 */
		public static void scrollUp(int pixel) {
			getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
		}

	}

