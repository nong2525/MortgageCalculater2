package com.automation.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryWedgets {
	private WebDriver driver;
	boolean isDemoMode = true;

	@BeforeMethod
	public void beforeEachTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTest() {
		delay(5);
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	public void highlightElement(WebElement element) {
		try {
			if (isDemoMode == true) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

				for (int i = 1; i < 2; i++) {
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

	public void delay(double inSecond) {
		try {

			long milliSecond = (long) (inSecond * 1000);

			Thread.sleep(milliSecond);

		} catch (Exception e) {
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

	
	@Test(enabled = false) // passes
	public void accordion() {
		WebElement accordionBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(1) > a"));
		accordionBtn.click();
		System.out.println("Step1: click on accordion");
		delay(1);
		
		iframe();
		WebElement section1 = driver.findElement(By.id("ui-id-1"));
		section1.click();
		System.out.println("Step2: click on section1");
		delay(1);
		WebElement sectoion2 = driver.findElement(By.id("ui-id-3"));
		sectoion2.click();
		System.out.println("Step3: click on section2");
		delay(1);
		WebElement sectoion3 = driver.findElement(By.id("ui-id-5"));
		sectoion3.click();
		System.out.println("Step4: click on section3");
		delay(1);
		WebElement sectoion4 = driver.findElement(By.id("ui-id-7"));
		sectoion4.click();
		System.out.println("step5: click on section4");

		defaultcontent();

	}
	

	@Test(enabled = false) // failed
	public void autoComplete() {
		System.out.println("Step1: locate the autoComplete button ");
		WebElement autocompleteBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[2]/a"));
		autocompleteBtn.click();
		iframe();

		WebElement tags = driver.findElement(By.id("tags"));
		tags.click();
		tags.sendKeys("java");

		tags.sendKeys(Keys.ARROW_DOWN);
		tags.sendKeys(Keys.ENTER);

		// Select dropdown = new Select(tags);
		// dropdown.selectByVisibleText("JavaScript");
		defaultcontent();
	}
	

	@Test(enabled = false) // passes
	public void button() {

		System.out.println("Step1: locate the  widget bottons and click all button");
		WebElement widgetButton = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a"));
		widgetButton.click();
		iframe();
		
		WebElement widgetButtonElem = driver.findElement(By.xpath("/html/body/div/button"));
		highlightElement(widgetButtonElem);
		widgetButtonElem.click();
		delay(1);
		WebElement widgetSubmitBtn = driver.findElement(By.xpath("/html/body/div/input"));
		highlightElement(widgetSubmitBtn);
		widgetSubmitBtn.click();
		delay(1);
		WebElement widgetAnchor = driver.findElement(By.xpath("/html/body/div/a"));
		highlightElement(widgetAnchor);
		widgetAnchor.click();
		delay(1);

		System.out.println("Step2: locate the  css bottons and click all button");
		WebElement cssButton = driver.findElement(By.xpath("/html/body/div/a"));
		highlightElement(cssButton);
		cssButton.click();
		delay(1);
		WebElement cssSubmitBtn = driver.findElement(By.xpath("/html/body/input"));
		highlightElement(cssSubmitBtn);
		cssSubmitBtn.click();
		delay(1);
		WebElement cssAnchor = driver.findElement(By.xpath("/html/body/a"));
		highlightElement(cssAnchor);
		cssAnchor.click();

		defaultcontent();

	}
	

	@Test(enabled = false) // passes
	public void checkboxRadio() {
		System.out.println("Step1: find location of checkboxRadio and click");
		String cssCheckboxRadio = "#sidebar > aside:nth-child(2) > ul > li:nth-child(4) > a";
		WebElement checkboxRadio = driver.findElement(By.cssSelector(cssCheckboxRadio));
		checkboxRadio.click();
		iframe();
		
		System.out.println("Step2: locate the (Select a Location) and click new york");
		WebElement selectALocationRadio = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]"));
		selectALocationRadio.click();
		delay(1);
		System.out.println("Step3: find location of hotel rating and click 3 and 5 stars");
		WebElement hotelRating5Stars = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[4]"));
		boolean checkboxState = hotelRating5Stars.isSelected();
		if (checkboxState != true) {
			hotelRating5Stars.click();
		}
		WebElement hotelRating3Stars = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]/span[1]"));
		boolean checkboxState2 = hotelRating3Stars.isSelected();
		if (checkboxState2 != true) {
			hotelRating3Stars.click();
		}
		System.out.println("Step4: find location of Bed type and click 2 double and 1 Queen");
		WebElement twoDoubleBed = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[1]"));
		boolean checkboxState3 = twoDoubleBed.isSelected();
		if (checkboxState3 != true) {
			twoDoubleBed.click();
		}
		WebElement oneQueenBed = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[3]"));
		boolean checkboxState4 = twoDoubleBed.isSelected();
		if (checkboxState4 != true) {
			oneQueenBed.click();
		}

		defaultcontent();

	}
	

	@Test(enabled = false) // passes
	public void controlGroup() {
		System.out.println("Step1: locate the controlGroup button and click");
		WebElement controlGroupBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[5]/a"));
		controlGroupBtn.click();
		iframe();
		
		delay(2);
		// Herizontal rental car
		System.out.println("Step2: locate the drop down compact car and click luxury ");
		WebElement compactCar = driver.findElement(By.xpath("//*[@id=\"car-type-button\"]/span[2]"));
		compactCar.click();
		delay(2);
		// Select dropdownComCar = new Select(compactCar);
		// dropdownComCar.selectByVisibleText("Luxury");
		WebElement luxury = driver.findElement(By.id("ui-id-5"));
		luxury.click();

		System.out.println("Step3: locate the radiobutton and click automatic");
		WebElement automaticRedio = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[2]"));
		automaticRedio.click();

		System.out.println("Step4: locate the insurance checkbox");
		WebElement insuranceCheckbox = driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/label[3]"));
		boolean checkboxState5 = insuranceCheckbox.isSelected();
		if (checkboxState5 != true) {
			insuranceCheckbox.click();
		}
		System.out.println("Step5: locate the # of car up ");
		WebElement numberOfCarUp = driver
				.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/span[2]/a[1]/span[1]"));
		for (int i = 1; i < 4; i++) {
			numberOfCarUp.click();
		}
		delay(2);
		System.out.println("Step6: locate the # of car down");
		WebElement numberOfCarDown = driver
				.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/span[2]/a[2]/span[1]"));
		for (int i = 1; i < 3; i++) {
			numberOfCarDown.click();
		}
		System.out.println("Step7: locate the book now button");
		WebElement bookNow = driver
				.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(2) > div > button"));
		highlightElement(bookNow);
		bookNow.click();

		// Vertical car rental
		System.out.println("Step8: locate the drop down compact car and click SUV ");
		WebElement compactCar2 = driver.findElement(By.xpath("//*[@id=\"ui-id-8-button\"]/span[2]"));
		compactCar2.click();
		delay(2);
		WebElement suv = driver.findElement(By.id("ui-id-12"));
		suv.click();

		System.out.println("Step9: locate the radiobutton and click standard");
		WebElement automaticRedio2 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[1]"));
		automaticRedio2.click();

		System.out.println("Step10: locate the insurance checkbox");
		WebElement insuranceCheckbox2 = driver.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/label[3]"));
		boolean checkboxState2 = insuranceCheckbox.isSelected();
		if (checkboxState2 != true) {
			insuranceCheckbox2.click();
		}
		System.out.println("Step11: locate the # of car up ");
		WebElement numberOfCarUp2 = driver
				.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/span[2]/a[1]/span[1]"));
		for (int i = 1; i < 3; i++) {
			numberOfCarUp2.click();
		}
		delay(2);
		System.out.println("Step12: locate the # of car down");
		WebElement numberOfCarDown2 = driver
				.findElement(By.xpath("/html/body/div[1]/fieldset[2]/div/span[2]/a[2]/span[1]"));
		for (int i = 1; i < 5; i++) {
			numberOfCarDown2.click();
		}
		System.out.println("Step7: locate the book now button");
		WebElement bookNow2 = driver.findElement(By.id("book"));
		highlightElement(bookNow2);
		bookNow2.click();

		defaultcontent();

	}

	
	@Test(enabled = false) // passes
	public void datePicker() {
		System.out.println("Step1: locate the datePicker button and click");
		WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"));
		datePickerBtn.click();
		System.out.println("Step2: locate iframe and Switch to iframe");
		iframe();
		
		WebElement date = driver.findElement(By.id("datepicker"));
		date.clear();
		date.sendKeys("04/05/2024");

		
		
		defaultcontent();
		
	}
	
	
	
	@Test(enabled = false)//passes  
	public void dialog() {
		System.out.println("Step1: locate dialog button and click");
		WebElement dialogBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[7]/a"));
		dialogBtn.click();
		
		iframe();
		delay(2);
		Actions action = new Actions(driver);
		
		WebElement move = driver.findElement(By.xpath("/html/body/div/div[1]"));
		action.dragAndDropBy(move, 100, 50).perform();
		
		delay(2);
		WebElement close = driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]"));
		close.click();
		
		defaultcontent();
		
	}
	
	@Test(enabled = false)//passes
	public void menu() {
		System.out.println("Step1: locate the mune button and click");
		WebElement menuBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[8]/a"));
		menuBtn.click();
		System.out.println("Step2: locate iframe and switch to iframe");
		iframe();
		Actions action = new Actions(driver);
		System.out.println("Step3: hover the mouse to menu item");
		WebElement menuItem = driver.findElement(By.id("menu"));
		action.moveToElement(menuItem).release().build().perform();
	
		delay(1);
		System.out.println("Step4: hover the mouse to books and click");
		WebElement books = driver.findElement(By.id("ui-id-2"));
		action.moveToElement(books).release().build().perform();
		books.click();
		
		delay(1);
		System.out.println("Step5: hover the mouse to clothing and click");
		WebElement clothing = driver.findElement(By.id("ui-id-3")); 
		action.moveToElement(clothing).release().build().perform();
		clothing.click();
		
		delay(1);
		System.out.println("Step6: hover the mouse to electornics ");
		WebElement electronics = driver.findElement(By.id("ui-id-4"));
		action.moveToElement(electronics).release().build().perform();
		delay(1);
		System.out.println("Step7: hover the mouse to car Hifi and click");
		WebElement carHifi = driver.findElement(By.id("ui-id-6"));
		action.moveToElement(carHifi).release().build().perform();
		carHifi.click();
		
		delay(1);
		System.out.println("Step8: hover the mouse to electornics ");
		WebElement electronics2 = driver.findElement(By.id("ui-id-4"));
		action.moveToElement(electronics2).release().build().perform();
		delay(1);
		System.out.println("Step9: hover the mouse to utilities and click");
		WebElement utilities = driver.findElement(By.id("ui-id-7"));
		action.moveToElement(utilities).release().build().perform();
		utilities.click();
		delay(1);
		System.out.println("Step10: hover the mouse to movies and click");
		WebElement movies = driver.findElement(By.id("ui-id-8"));
		action.moveToElement(movies).release().build().perform();
		movies.click();
		delay(1);
		System.out.println("Step11: hover the mouse to music");
		WebElement music = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music).release().build().perform();
		delay(1);
		System.out.println("Step12: hover the mouse to rock");
		WebElement rock = driver.findElement(By.id("ui-id-10"));
		action.moveToElement(rock).release().build().perform();
		delay(1);
		System.out.println("Step13: hover the mouse to alternative and click");
		WebElement alternative = driver.findElement(By.id("ui-id-11"));
		action.moveToElement(alternative).release().build().perform();
		alternative.click();
		
		delay(1);
		
		WebElement music2 = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music2).release().build().perform();
		delay(1);
		WebElement rock2 = driver.findElement(By.id("ui-id-10"));
		action.moveToElement(rock2).release().build().perform();
		delay(1);
		WebElement classic = driver.findElement(By.id("ui-id-12"));
		action.moveToElement(classic).release().build().perform();
		classic.click();
		
		WebElement music3 = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music3).release().build().perform();
		delay(1);
		WebElement jazz = driver.findElement(By.id("ui-id-13"));
		action.moveToElement(jazz).release().build().perform();
		delay(1);
		WebElement freeJazz = driver.findElement(By.id("ui-id-14"));
		action.moveToElement(freeJazz).release().build().perform();
		freeJazz.click();
		
		WebElement music4 = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music4).release().build().perform();
		delay(1);
		WebElement jazz2 = driver.findElement(By.id("ui-id-13"));
		action.moveToElement(jazz2).release().build().perform();
		delay(1);
		WebElement bigBand = driver.findElement(By.id("ui-id-15"));
		action.moveToElement(bigBand).release().build().perform();
		bigBand.click();
		
		WebElement music5 = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music5).release().build().perform();
		delay(1);
		WebElement jazz3 = driver.findElement(By.id("ui-id-13"));
		action.moveToElement(jazz3).release().build().perform();
		delay(1);
		WebElement modern = driver.findElement(By.id("ui-id-16"));
		action.moveToElement(modern).release().build().perform();
		modern.click();
		
		WebElement music6 = driver.findElement(By.id("ui-id-9"));
		action.moveToElement(music6).release().build().perform();
		delay(1);
		WebElement pop = driver.findElement(By.id("ui-id-17"));
		action.moveToElement(pop).release().build().perform();
		pop.click();
		
		defaultcontent();
		
		
	}
	
	
	@Test(enabled = false)//failed haven't figure it out yet
	public void progressBar() {
		System.out.println("Step1: locate progressBar button and click");
		WebElement progressBarBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[9]/a"));
		progressBarBtn.click();
		
		iframe();
		WebElement progress = driver.findElement(By.id("progressbar"));
		WebElement progressing = driver.findElement(By.xpath("//*[@id=\"progressbar\"]/div"));
		Actions action = new Actions(driver);
		action.clickAndHold(progressing).moveToElement(progress, 80, 0).release().build().perform();
	}
	
	
	@Test(enabled = false)//title failed
	public void selectMenu() {
		WebElement selectMenuBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[10]/a"));
	    selectMenuBtn.click();
	    
	    iframe();
	    WebElement selectASpeed = driver.findElement(By.xpath("//*[@id=\"speed-button\"]/span[1]"));
	    selectASpeed.click();
	    delay(1);
	    WebElement speed = driver.findElement(By.id("ui-id-5"));
	    speed.click();
	    delay(1);
	    
	    WebElement selectAFile = driver.findElement(By.xpath("//*[@id=\"files-button\"]/span[1]"));
	    selectAFile.click();
	    delay(1);
	    WebElement file = driver.findElement(By.xpath("//*[@id=\"files-menu\"]/li[5]"));
	    file.click();
	    delay(1);
	    
	    WebElement selectANumber = driver.findElement(By.xpath("//*[@id=\"number-button\"]/span[1]"));
	    selectANumber.click();
	    delay(1);
	    WebElement number = driver.findElement(By.xpath("//*[@id=\"number-menu\"]/li[15]"));
	    number.click();
	    
	    //this is failed
	    
	    WebElement selectATitle = driver.findElement(By.xpath("//*[@id=\"salutation-button\"]/span[1]"));
	    selectATitle.click();
	    delay(1);
	    
	    WebElement title = driver.findElement(By.id("ui-id-3"));
	    title.click();
	    
	    
	    
	    defaultcontent();
	}
	
	

	@Test(enabled = false) // passes
 	public void testSlider() {
		System.out.println("Step1: locate the slider and click ");
		WebElement sliderBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[11]/a"));
		sliderBtn.click();

		iframe();
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		int width = mainSlider.getSize().getWidth() / 2;
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, width, 0).perform();
		delay(2);
		action.dragAndDropBy(slider, 200, 0).perform();

		defaultcontent();
	}
	
	
	
	@Test(enabled = true)//getValue failed
	public void spinner() {
		WebElement spinnerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[12]/a"));
		spinnerBtn.click();
		
		iframe();
		WebElement selectAValueDown = driver.findElement(By.xpath("/html/body/p[1]/span/a[2]/span[1]"));
		for(int i=0; i < 4; i++ ) {
		selectAValueDown.click();
		}
		delay(1);
		WebElement selectAValueUp = driver.findElement(By.xpath("/html/body/p[1]/span/a[1]/span[1]"));
		for(int i=0; i < 6; i++ ) {
		selectAValueUp.click();
		}
		
		WebElement toggleDisable = driver.findElement(By.id("disable"));
		highlightElement(toggleDisable);
	    toggleDisable.click();
		WebElement toggleWidget = driver.findElement(By.id("destroy"));
		highlightElement(toggleWidget);
		toggleWidget.click();
		
		//can't figure it our yet
		//WebElement getValue = driver.findElement(By.id("getvalue"));
		//getValue.click();
		
		WebElement setValue = driver.findElement(By.id("setvalue"));
		highlightElement(setValue);
		setValue.click();
		
	}
	
	
	@Test(enabled = false)//passes
	public void tabs() {
		WebElement tabsBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[13]/a"));
		tabsBtn.click();
		
		iframe();
		WebElement proinDolor = driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
		proinDolor.click();
		delay(1);
		WebElement aeneanLacinia =  driver.findElement(By.id("ui-id-3"));
		aeneanLacinia.click();
		
		defaultcontent();
		
	}
	
	
	@Test(enabled = false)// passes
	public void toolTips() {
		WebElement toolTipsBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[14]/a"));
		toolTipsBtn.click();
		
		iframe();
		Actions action = new Actions(driver);
		WebElement toolTips = driver.findElement(By.xpath("/html/body/p[1]/a"));
		action.moveToElement(toolTips).release().build().perform();
		delay(1);
		WebElement themeRoller = driver.findElement(By.xpath("/html/body/p[2]/a"));
		action.moveToElement(themeRoller).release().build().perform();
		delay(1);
		WebElement age = driver.findElement(By.id("age"));
		age.sendKeys("41");
	}

}
