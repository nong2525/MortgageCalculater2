package com.automation.week4;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumAdvanceMethodsTest extends Base {
	@Test(enabled = false)
	public void radioButtonTest() {
		String radioURL = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio";
		driver.get(radioURL);
		// switch to iframe
		driver = driver.switchTo().frame("iframeResult");

		WebElement javaScriptRadioBtn = driver.findElement(By.id("javascript"));
		javaScriptRadioBtn.click();

		// exit from iframe
		driver = driver.switchTo().defaultContent();

	}

	@Test(enabled = true)
	public void learnHoverOver() {
		
		driver.get("https://www.usps.com/");
		//locate "quick tools" main menu
		captureScreenshot();
		WebElement quickToolElem = driver.findElement(By.linkText("Quick Tools"));
		highlightElement(quickToolElem);
		
		//Initially mouse action
		Actions action = new Actions(driver);
		action.moveToElement(quickToolElem).build().perform();
		
		delay(2);
		
		WebElement receiveEle = driver.findElement(By.partialLinkText("Receive"));
		highlightElement(receiveEle);

		action.moveToElement(receiveEle).build().perform();
	}
	public String captureScreenshot() {
        String screenshotPath = null;
        try {
            String filePath = "target/screenshot.png";
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
            
        }catch (Exception e) {
            e.printStackTrace();
        }        
        return screenshotPath;
    }
		
	
	
		
}
