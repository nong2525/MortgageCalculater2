package com.automation.week1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice1MortgageCal {
	private WebDriver driver;
	private String WebsiteURL = "https://www.mortgagecalculator.org/";
	
	@Test
	public void buyYourHouse() {
		try {
		System.out.println("Step1: open the chrom browser ");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		System.out.println("Step2: go to the website " + WebsiteURL);
		driver.get(WebsiteURL);
		
		//maximize the browser
		driver.manage().window().maximize();
		
		String websiteTitle = driver.getTitle();
		System.out.println("Step3: get the website title" + websiteTitle);
		String expectedWebsiteTitle = "Mortgage Calculator";
		
		assertEquals(websiteTitle, expectedWebsiteTitle);
		System.out.println("Step4: website title verified sucessful");
		
		System.out.println("Step5: locate the Home value enter 600000");
		WebElement homeValue = driver.findElement(By.id("homeval"));
		homeValue.clear();
		homeValue.sendKeys("600000");
		
		System.out.println("Step6: locate the down payment and enter 60000");
		WebElement downPayment = driver.findElement(By.id("downpayment"));
		downPayment.clear();
		downPayment.sendKeys("60000");
		
		System.out.println("Step7: locate the loan amount and enter 540000 ");
		WebElement loanAmount=driver.findElement(By.id("loanamt"));
		loanAmount.clear();
		loanAmount.sendKeys("540000");
		
		System.out.println("Step8: locate the interest rate and enter 7.5 ");
		WebElement interestRate = driver.findElement(By.id("intrstsrate"));
		interestRate.clear();
		interestRate.sendKeys("7.5");
		
		//WebElement todayBestRate = driver.findElement(By.cssSelector("#calc > form > section > section.content-area > div > div > div.calculation-container > div > div > div.cal-content > div.cal-left-box > div.calcu-block > div:nth-child(5) > a > input"));
	    //todayBestRate.click();
	    //WebElement bestRatePopUp = driver.findElement(By.id("cboxClose"));
	    //bestRatePopUp.click();
		
		System.out.println("Step9: locate loan term and enter 29 ");
		WebElement loanTerm = driver.findElement(By.id("loanterm"));
		loanTerm.clear();
		loanTerm.sendKeys("29");
		
		System.out.println("Step10: locate Start date drop-down and then click April");
		WebElement startDate = driver.findElement(By.name("param[start_month]"));
		Select dropDownStartDate = new Select(startDate);
		dropDownStartDate.selectByVisibleText("Apr");
		
		System.out.println("Step11: locate Start year and enter 2024");
		WebElement startYear = driver.findElement(By.id("start_year"));
		startYear.clear();
		startYear.sendKeys("2024");
		
		System.out.println("Step12:Locate property tax enter 2690");
		WebElement propertyTax = driver.findElement(By.id("pptytax"));
		propertyTax.clear();
		propertyTax.sendKeys("2690");
		
		System.out.println("Step13: Locate PMI and enter 0.3");
		WebElement pmi = driver.findElement(By.id("pmi"));
		pmi.clear();
		pmi.sendKeys("0.3");
		
		System.out.println("Step14: Locate home ins  and enter 1700");
		WebElement homeIns = driver.findElement(By.id("hoi"));
		homeIns.clear();
		homeIns.sendKeys("1700");
		
		System.out.println("Step15: Locate monthly HOA  and enter 150");
		WebElement monthlyHOA = driver.findElement(By.id("hoa"));
		monthlyHOA.clear();
		monthlyHOA.sendKeys("150");
		
		System.out.println("Step16: locate monthly loan type drop-down and then click VA");
		WebElement loantype = driver.findElement(By.name("param[milserve]"));
		Select dropDownLoanType = new Select(loantype);
		dropDownLoanType.selectByVisibleText("VA");
		
		System.out.println("Step17: locate Buy or refi drop-down and then click refi");
		WebElement buyOrRefi = driver.findElement(By.name("param[refiorbuy]"));
		Select dropDownBuyOrRefi = new Select(buyOrRefi);
		dropDownBuyOrRefi.selectByVisibleText("Refi");
		
		System.out.println("Step18: locate calculate and click");
		WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calc\"]/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[1]/div[1]/div[14]/a/input"));
		
		calculate.click();
		Thread.sleep(10 * 1000);
		String monthlyPaymentCSS = "#calc > form > section > section.content-area > div > div > div.calculation-container > div > div > div.cal-content > div.cal-right-box > div > div:nth-child(1) > div.left-cell > h3";
		WebElement monthlyPayment = driver.findElement(By.cssSelector(monthlyPaymentCSS));
		System.out.println("monthly payment is: " + monthlyPayment.getText());
		assertEquals(monthlyPayment.getText(), "$2,721.94");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}

}
