package com.automation.week1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MortgageCalculator {

	private WebDriver driver;
	private String websiteURL = "https://www.mortgagecalculator.net/";
	//if isHeadless is true it won't show the browser
	private boolean isHeadless = true;

	@Test
	public void buyAHouseTest() {
		try {
			// setup the chrome driver file location
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver (1).exe");

			// start a chrome browser
			System.out.println("Step1: opening the chrome browser");
			ChromeOptions chromeOptions = new ChromeOptions();

			if (isHeadless == true) {
				chromeOptions.addArguments("--headless");
			}

			// chromeOptions.addArguments("--window-size-1400");
			chromeOptions.addArguments("--start-maximized");

			driver = new ChromeDriver(chromeOptions);
			//set implicit wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			System.out.println("Step1.1: maximizing browser.");
			driver.manage().window().maximize();
			// for Mac operating // for Mac operating sytem
			// driver = new SafariDriver();

			// navigate to mortgage calculator website
			System.out.println("Step2: goto website: " + websiteURL);
			driver.get(websiteURL);

			// get the website title
			String WebsiteTitle = driver.getTitle();
			System.out.println("Step3: actual website title: " + WebsiteTitle);
			String expectedWebsiteTitle = "Mortgage Calculator 2023 - FREE Calculator Tool (ZERO Ads)";
			
			assertEquals(WebsiteTitle, expectedWebsiteTitle);
			System.out.println("Step4: Website title verified sucessful");
			
			// Locate amount text field
			System.out.println("Step5: entering 270,000 for amount text field.");
			WebElement amountElem = driver.findElement(By.id("amount"));
			amountElem.clear();
			amountElem.sendKeys("270000");
			System.out.println("Step6: locate interest rate text field and enter 7.5 ");

			// locate interest rate text field
			WebElement interestRate = driver.findElement(By.name("rate"));
			interestRate.clear();
			interestRate.sendKeys("7.5");

			System.out.println("Step7: locate amortization year anad enter 29");
			// locate amortization year
			WebElement amortYear = driver.findElement(By.cssSelector("#amortizationYears"));
			amortYear.clear();
			amortYear.sendKeys("29");

			System.out.println("Step8: lacaate amortization month and enter 11");
			WebElement amortMount = driver.findElement(By.xpath("//*[@id=\"amortizationMonths\"]"));
			amortMount.clear();
			amortMount.sendKeys("11");

			System.out.println("Step9: locate start month drop-down element and selcet 5");
			// Locate start month drop down element
			WebElement startMonthElem = driver.findElement(By.id("startMonth"));
			Select dropdownSelect = new Select(startMonthElem);
			dropdownSelect.selectByVisibleText("5");

			System.out.println("Step10: locate start year drop-down element and selct 2024");
			// Locate start year drop-down element
			WebElement startYearElem = driver.findElement(By.id("startYear"));

			Select dropdownSelectYear = new Select(startYearElem);
			dropdownSelectYear.selectByIndex(1);

			System.out.println("Step11: locate interest term year and enter 29");
			WebElement intTermYear = driver.findElement(By.cssSelector("#interestTermYears"));
			intTermYear.clear();
			intTermYear.sendKeys("29");

			System.out.println("Step12: locate interest term month and enter 5");
			WebElement intTermMonth = driver.findElement(By.xpath("//*[@id=\"interestTermMonths\"]"));
			intTermMonth.clear();
			intTermMonth.sendKeys("5");

			System.out.println("Step13: locate payment mode drop-down and select 'Semi-Monthly' option");
			WebElement paymentModeDropDown = driver.findElement(By.id("paymentMode"));
			Select paymentModeSelect = new Select(paymentModeDropDown);
			paymentModeSelect.selectByVisibleText("Semi-Monthly");

			System.out.println("Step14: locate interest type drop-down and select 'Fixed' option");
			WebElement intTypeDropDown = driver.findElement(By.id("interestType"));
			Select intTypeSelect = new Select(intTypeDropDown);
			intTypeSelect.selectByVisibleText("Fixed");

			System.out.println("Step15: locate 'Calculate Now' button and click it");
			WebElement calculateBtn = driver.findElement(By.cssSelector("#button"));
			calculateBtn.click();
			
			//selenium is too fast, pause the thread/code executed 5 second
			//Thread.sleep(5 * 1000);
			//explicit wait ---- that means, we ask selenium to wait for certain element state/condition
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement summaryElem = wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("summaryMonthly")));
			assertNotNull(summaryElem, "Mortgage Calculater Result page is not displayed within 30 seconds.");

			// verify the monthly payment amount is equal to $1,889.23
			System.out.println(
					"Step16: locate 'Monthly Payment filed' " 
			        +" extract the text and compare with expected value");
			WebElement monthlyPaymentElem = driver.findElement(By.id("summaryMonthly"));
			String monthlyPaymentAmount = monthlyPaymentElem.getAttribute("value");
			System.out.println("actual monthly payment is: " + monthlyPaymentAmount);
			assertEquals(monthlyPaymentAmount, "$1,889.23");
			
		

			System.out.println("Delaying for 10 seconds");
			Thread.sleep(10 * 1000);

			System.out.println("Final step: Closing chrome brownser");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
