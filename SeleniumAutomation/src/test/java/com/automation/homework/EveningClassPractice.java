package com.automation.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EveningClassPractice {
	private WebDriver driver;
	
	@Test
 	public void beforEachTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.kayak.com/");
		driver.manage().window().maximize();
		WebElement adi= driver.findElement(By.xpath("//*[@id=\"c-dov\"]/div/div/div/div[1]/div[2]/div/div[1]/div/div/div/div[1]/div[1]"));
		adi.click();
		WebElement from =  driver.findElement(By.xpath("//*[@id=\"jt-6\"]/div/div/div/div[1]/div[2]/div/div[1]/div/div/div/div[2]/svg"));
		from.click();
		from.sendKeys("bwi");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
}
}
