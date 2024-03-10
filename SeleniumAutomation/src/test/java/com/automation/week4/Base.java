package com.automation.week4;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;
	public boolean isDemoMode = false;

	@BeforeMethod
	public void beforEachTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterEachTest() {
		try {
		Thread.sleep(5 * 1000);
	
		if (driver !=null) {
			driver.close();
			driver.quit();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void highlightElement(WebElement element) {
		try {
			if (isDemoMode == true) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

				for (int i = 1; i < 4; i++) {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow");
					delay(0.5);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
					delay(0.5);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delay(double inSeconds) {
		try {
			// casting or converting data type from Double to Long
			long milliSec = (long) (inSeconds * 1000);
			Thread.sleep(milliSec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
