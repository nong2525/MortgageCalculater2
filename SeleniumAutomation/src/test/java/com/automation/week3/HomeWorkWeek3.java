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

public class HomeWorkWeek3 {
	private WebDriver driver;
		
		@BeforeMethod
		public void beforeMethod() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			
		}
		
		@AfterMethod
		public void afterMethod() {
			if(driver !=null) {
				driver.close();
				driver.quit();
			}
			
		}
		

		

		//find total Link without text
		@Test(enabled = false)
		public void countAllLink() {
			driver.get("https://www.costco.com/");
			
			List<WebElement> allLinkElements = driver.findElements(By.tagName("a"));
			
			int totalLinks = allLinkElements.size();
			System.out.println("total of the link:  " + totalLinks);
			
		}
		//find total link with text 
		@Test(enabled = true)
		public void findAllLinks() {
			
			driver.get("https://www.costco.com/");
		    
			List<WebElement> allLinkElements = driver.findElements(By.tagName("a"));
			
			int totalLinks = allLinkElements.size();
			System.out.println("total of the Links:  " + totalLinks);
			
			List<String> linksWithNoText = new ArrayList<String>();
			List<String> linksWithText = new ArrayList<String>();
			
			int counter = 1;
			for(WebElement aLink : allLinkElements) {
				String linkText = aLink.getText();
				System.out.println("("+ counter + ") Link text: [" +linkText+"]");
				counter++;
				if(linkText.isEmpty()) {
				linksWithNoText.add(linkText);		
				}
				if(!(linkText.isEmpty())) {
					linksWithText.add(linkText);
				}
			}
			int counter2 = 1;
			for(String noText : linksWithNoText) {
				System.out.println("("+ counter2 +")Link with no text: [" +noText+ "]");
				  counter2++;
				
			}
			int counter3 = 1;
			for(String withText : linksWithText) {
				System.out.println("("+ counter3 +")Link with no text: [" +withText+ "]");
				  counter3++;
			}
			System.out.println("total of the Links:  " + totalLinks);
			
			System.out.println("("+ counter + ") Link without text: [" + linksWithNoText.size() +"]");
			
			System.out.println("("+ counter + ") Link with text: [" + linksWithText.size() +"]");
		
		}

}
