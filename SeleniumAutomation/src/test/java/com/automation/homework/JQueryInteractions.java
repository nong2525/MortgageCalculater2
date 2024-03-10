package com.automation.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryInteractions{
	private WebDriver driver;
	
	@BeforeMethod
	public void beforEachTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterEactTest() {
		delay(5);
		if(driver != null) {
		driver.close();
		driver.quit();
		}
	}
	
	public void delay(double inSecond) {
		try {
			
		long milliSecond = (long)(inSecond * 1000);
		Thread.sleep(milliSecond);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void iframe() {
		driver = driver.switchTo().frame(0);
		//WebElement frame = driver.findElement(By.xpath("//*[@id=\\\"content\\\"]/iframe"));
		//driver.switchTo().frame(frame);
		//driver = driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
	}
	public void defaultcontent() {
		driver = driver.switchTo().defaultContent();
	}
	
	@Test(enabled = true )
	public void interactions() {
		//draggable
		
		System.out.println("Step1: locate the draggable button and click");
		WebElement draggableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
		draggableBtn.click();
		System.out.println("Step2: switch to iframe");
		iframe();
		
		System.out.println("Step3: locate the square to drag");
		WebElement dragMe = driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		Actions action = new Actions(driver);
		
		System.out.println("Step4: drag the square 50,50");
		action.dragAndDropBy(dragMe, 50, 50).perform();
		delay(2);
		System.out.println("Step6: drag the square 100,125 ");
		action.dragAndDropBy(dragMe, 100, 125).perform();
		defaultcontent();
		
		//droppable
		System.out.println("Step1: locate the droppable buttonn and click");
		WebElement droppableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		droppableBtn.click();
		System.out.println("Step2:  switch to iframe");
		iframe();
		System.out.println("Step3: locate the draggable square and drag and drop to the target square");
		Actions action2 = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action2.clickAndHold(drag).moveToElement(drop).release().build().perform();
		defaultcontent();
		
		//resizable
		System.out.println("Step1: locate the resizable button and click");
		WebElement resizableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a"));
		resizableBtn.click();
		
		System.out.println("Step2: switch to iframe");
		iframe();
		System.out.println("Step3: locate the resizable and make it bigger");
		WebElement dragBigger = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions action3 = new Actions(driver);
		action3.dragAndDropBy(dragBigger, 100, 125).perform();
		defaultcontent();
		
		//selectable
		System.out.println("Step1: locate the selectable button and click");
		WebElement selectableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a"));
		selectableBtn.click();
		System.out.println("Step2: switch to iframe");
		iframe();
		System.out.println("Step3: locate item2 and click");
		WebElement item2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
		item2.click();
		delay(2);
		System.out.println("Step4: locate item5 and click");
		WebElement item5 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[5]"));
		item5.click();
		defaultcontent();
		
		//sortable
		System.out.println("Step1: locate the sortable button and click");
		WebElement sortableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[5]/a"));
		sortableBtn.click();
		System.out.println("Step2:  switch to iframe");
		iframe();
		System.out.println("Step3: Sort the item desc(descending order)");
		WebElement item7 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[7]"));
		WebElement item6 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[6]"));
		WebElement item51 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[5]"));
		WebElement item4 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[4]"));
		WebElement item3 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
		WebElement item21 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		
		Actions action4 = new Actions(driver);
		action4.clickAndHold(item7).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item6).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item51).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item4).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item3).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item21).moveToElement(item1).release().build().perform();
		
		defaultcontent();
	
	}
	
	
	
	@Test(enabled = false)
	public void draggable() {
		System.out.println("Step1: locate the draggable button and click");
		WebElement draggableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
		draggableBtn.click();
		System.out.println("Step2:  switch to iframe");
		iframe();
		
		System.out.println("Step3: locate the square to drag");
		WebElement dragMe = driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		Actions action = new Actions(driver);
		
		System.out.println("Step4: drag the square 50,50");
		action.dragAndDropBy(dragMe, 50, 50).perform();
		delay(2);
		System.out.println("Step6: drag the square 100,125 ");
		action.dragAndDropBy(dragMe, 100, 125).perform();
		
		defaultcontent();
		
		}
	
	
	@Test(enabled = false)
	public void droppable() {
		System.out.println("Step1: locate the droppable buttonn and click");
		WebElement droppableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		droppableBtn.click();
		System.out.println("Step2: switch to iframe");
		iframe();
		
		System.out.println("Step3: locate the draggable square and drag and drop to the target square");
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		
		defaultcontent();
	
	}
	
	@Test(enabled = false)
	public void droppable2() {
		System.out.println("Step1: locate the droppable button and click");
		WebElement droppableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		droppableBtn.click();
		System.out.println("Step2: switch to iframe");
		iframe();
		
		System.out.println("Step3: locate the draggable square and drag and drop to the target square");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		
		defaultcontent();
		
	}
	@Test(enabled = false)
	public void resizable() {
		System.out.println("Step1: locate the resizable button and click");
		WebElement resizableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a"));
		resizableBtn.click();
		
		System.out.println("Step2:  switch to iframe");
		iframe();
		
		System.out.println("Step3: locate the resizable and make it bigger");
		WebElement dragBigger = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions action3 = new Actions(driver);
		action3.dragAndDropBy(dragBigger, 100, 125).perform();
		
		defaultcontent();
	
	
	}
	@Test(enabled = false)
	public void selectable() {
		System.out.println("Step1: locate the selectable button and click");
		WebElement selectableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a"));
		selectableBtn.click();
		System.out.println("Step2:  switch to iframe");
		iframe();
		System.out.println("Step3: locate item2 and click");
		WebElement item2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
		item2.click();
		delay(2);
		System.out.println("Step4: locate item5 and click");
		WebElement item5 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[5]"));
		item5.click();
		defaultcontent();
	}
	
	@Test(enabled = false)
	public void sortable() {
		System.out.println("Step1: locate the sortable button and click");
		WebElement sortableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[5]/a"));
		sortableBtn.click();
		System.out.println("Step2: switch to iframe");
		iframe();
		
		System.out.println("Step3: Sort the item desc(descending order)");
		WebElement item7 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[7]"));
		WebElement item6 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[6]"));
		WebElement item5 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[5]"));
		WebElement item4 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[4]"));
		WebElement item3 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
		WebElement item2 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		
		Actions action4 = new Actions(driver);
		action4.clickAndHold(item7).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item6).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item5).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item4).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item3).moveToElement(item1).release().build().perform();
		action4.clickAndHold(item2).moveToElement(item1).release().build().perform();
		
		defaultcontent();
	}
	
	

}
