package com.automation.week3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumMethodsTest {
	private WebDriver driver;
	// create a method that starts chrome browser before each test
	//@BeforeMethos--->runs before each test method
	//@BeforeTest--->runs one-time before whole test

	@BeforeMethod
	public void beforEachTest() {
		// open the Chrome browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterEachTest() {
		try {
			//delay 5 second
		Thread.sleep(5 * 1000);
		//close browser if there is open browser only
		if (driver !=null) {
			driver.close();
			//driver.quit();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// this means, this test is disabled/skipped
	@Test(enabled = false)
	public void seleniumTests() {
		try {

			// navigate to a URL
			driver.get("https://www.costco.com/");

			Thread.sleep(2 * 1000);

			// navigate to another URL
			driver.navigate().to("https://www.google.com/");
			Thread.sleep(2 * 1000);

			// go back to previous web-site/web-page
			driver.navigate().back();
			Thread.sleep(2 * 1000);

			// go forward to the next web-page/web-site
			driver.navigate().forward();
			Thread.sleep(2 * 1000);

			// refresh/reload web-site/web-page
			driver.navigate().refresh();
			Thread.sleep(2 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	
	//homework
	//1)find total link with no text
	//2)find total link with text
	@Test(enabled = true)
	public void findLinksHomeWork() {
		driver.get("https://www.costco.com/");
		List<WebElement>allLinkElement = driver.findElements(By.tagName("a"));
		
		int totalLinks = allLinkElement.size();
		
		System.out.println("Total number of links: " + totalLinks);
		
		List<String>linksWithNoText = new ArrayList<String>();
		List<String>linksWithText = new ArrayList<String>();
		  int counter =1; for(WebElement aLink : allLinkElement) { 
			  String linkText = aLink.getText(); 
			  
			  //remove extra space beginning and end of the variable value
			  linkText = linkText.trim();
			  
			  //if(linkText.isEmpty()) {
			  if(linkText == "") {
				  linksWithNoText.add(linkText);
			  }
			 // if (linkText != "") {
				if(!(linkText.isEmpty())) { 
					linksWithText.add(linkText);
			  }
	System.out.println("("+ counter +")Link text: [" +linkText+ "]");		  
	 
	counter++; }
		  int counter2 = 1;
		  for(String noText :linksWithNoText) {
			  System.out.println("("+ counter2 +")Link with no text: [" +noText+ "]");
			  counter2++;
		  }
		  int counter3 = 1;
		  for(String withText :linksWithText) {
			  System.out.println("("+ counter3 +")Link with text: [" +withText+ "]");
			  counter3++;
		  }
		 
   System.out.println("Total number of links no text : " + linksWithNoText.size());		
   System.out.println("Total number of links text : " + linksWithText.size());
	}
	
	
	
	@Test(enabled = false)
	public void findAllLinksTest() {
		// repuirement: fine all the links on costco.com home-page
		driver.get("https://www.costco.com/");
		List<WebElement>allLinkElement = driver.findElements(By.tagName("a"));
		
		int totalLinks = allLinkElement.size();
		
		System.out.println("Total number of links: " + totalLinks);
		
		//advance for loop or for-each loop
		
		  int counter =1; for(WebElement aLink : allLinkElement) { String linkText =
		  aLink.getText(); System.out.println("("+ counter +")Link text: [" +linkText+
		 "]"); counter++; }
		 
			
		  //regular loop example
			/*
			 * for(int i = 0; i < totalLinks; i++) { 
			 * WebElement aLink = allLinkElement.get(i) ; 
			 * String linkText = aLink.getText(); 
			 * int counter2 = i+1; 
			 * System.out.println("("+ counter2 +")Link text: [" +linkText+ "]"); }
			 */
			
		}
		
	//checkbox
	@Test(enabled = false)
	public void checkboxTesting() {
		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox";
		
		driver.get(url);
		
		//the checkbox is locaed inside a iframe html tag,
		//that's why we need to locate/ switch to iframe first 
		//then locate the checbox
		
		driver = driver.switchTo().frame("iframeResult");
		//locate the 2nd checkbox
		WebElement checkbox2 = driver.findElement(By.id("vehicle2"));
		//goal is we want to check the box
		boolean checkboxState = checkbox2.isSelected();
		if(checkboxState !=true) {
			checkbox2.click();
		}
		
		//business is inside the iframe 
		driver = driver.switchTo().defaultContent();
		
	}

	
}
