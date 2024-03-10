package com.automation.homework;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHomework {
	private WebDriver driver;
	boolean isDemoMode = true;
	

	@BeforeMethod
 	public void beforEachTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTest() {
		try {
			Thread.sleep(5 * 1000);

			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public void delay(double inSeconds) {
		try {
			// casting or converting data type from Double to Long
			long milliSec = (long) (inSeconds * 1000);
			Thread.sleep(milliSec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test(enabled = false)
	public void draggable() {
		System.out.println("Step1: locte the draggable button and click");
		WebElement draggableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
		draggableBtn.click();
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver = driver.switchTo().frame(frame);
		WebElement dragAround = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragAround, 100, 125).perform();
		delay(2);
		action.dragAndDropBy(dragAround, 90, 130).perform();
		
	}
	@Test(enabled = false)//passes
	public void dragAndDrop1() {
		System.out.println("Step1: locate the droppable button and click");
		WebElement droppableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		droppableBtn.click();
		driver = driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.clickAndHold(drag)
		.moveToElement(drop)
		.release().build().perform();
		
		driver = driver.switchTo().defaultContent();
		
	}
	@Test(enabled = false)//passes
	public void dragAndDrop2() {
		System.out.println("Step1: locate the droppable button and click");
		WebElement droppableBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		droppableBtn.click();
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver = driver.switchTo().frame(frame);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		driver = driver.switchTo().defaultContent();
	}
	@Test(enabled = false)
	public void resizable() {
		System.out.println("Step1: locate the resizable and resize biger");
		WebElement resizablebutton = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a"));
		resizablebutton.click();
		
		driver = driver.switchTo().frame(0);
		WebElement resizeBigger = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizeBigger, 300, 100).perform();
		
		driver = driver.switchTo().defaultContent();	}

	@Test(enabled = false) // passes
	public void accordion() {

		WebElement accordionBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(1) > a"));
		accordionBtn.click();
		System.out.println("Step1: click on accordion");
		delay(1);
		driver = driver.switchTo().frame(0);
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

		driver = driver.switchTo().defaultContent();

	}

	@Test(enabled = false) // failed
	public void autocomplete() {
		WebElement autocompleteBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[2]/a"));
		autocompleteBtn.click();
		System.out.println("Step1: find location autocomplete and type java and select JavaScript");
		driver = driver.switchTo().frame(0);
		WebElement tags = driver.findElement(By.id("tags"));
		tags.sendKeys("java");
		Select dropdown = new Select(tags);
		dropdown.selectByVisibleText("JavaScript");
		driver = driver.switchTo().defaultContent();
	}

	@Test(enabled = false) // passes
	public void button() {

		System.out.println("Step1: find location widget bottons and click all button");
		WebElement widgetButton = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a"));
		widgetButton.click();
		driver = driver.switchTo().frame(0);
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

		System.out.println("Step2: find location css bottons and click all button");
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

		driver = driver.switchTo().defaultContent();

	}

	@Test(enabled = false) // passes
	public void checkboxRadio() {
		System.out.println("Step1: find location of checkboxRadio and click");
		String cssCheckboxRadio = "#sidebar > aside:nth-child(2) > ul > li:nth-child(4) > a";
		WebElement checkboxRadio = driver.findElement(By.cssSelector(cssCheckboxRadio));
		checkboxRadio.click();
		System.out.println("Step2: find location of Select a Location and click new york");
		driver = driver.switchTo().frame(0);
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

		driver = driver.switchTo().defaultContent();
	}

	@Test(enabled = false)//passes
	public void controlGroup() {
		System.out.println("Step1: locate the controlGroup button and click");
		WebElement controlGroupBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[5]/a"));
		controlGroupBtn.click();
		driver = driver.switchTo().frame(0);
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

		driver = driver.switchTo().defaultContent();

	}

	@Test(enabled = false) //not finish 
	public void datePicker() {
		System.out.println("Step1: locate the date picker button and click");
		WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"));
        datePickerBtn.click();
        
        System.out.println("Step2: locate the date 03/09/1981");
        WebElement dateBtn = driver.findElement(By.id("datepicker"));
        dateBtn.click();
	}
	@Test(enabled = false)
	public void dialog (){
		System.out.println("Step1: locate the dialog and click close");
		WebElement dialogBtn = driver.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(7) > a"));
		dialogBtn.click();
		driver = driver.switchTo().frame(0);
		
	
		WebElement basicDialog = driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]"));
	    basicDialog.click();
		
		
		driver = driver.switchTo().defaultContent();
	}
	
	@Test(enabled = true)
	public void testSlider() {
		System.out.println("Step1: locate the slider and click ");
		WebElement sliderBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[11]/a"));
		sliderBtn.click();
		
		driver = driver.switchTo().frame(0);
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		int width = mainSlider.getSize().getWidth()/2;
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, width, 0).perform();
	    delay(2);
		action.dragAndDropBy(slider, 200, 0).perform();
	
		
		driver = driver.switchTo().defaultContent();
	
		
	}
	int targetDay = 0, targetMonth = 0, targetYear= 0;
	int currentDay = 0, currentMonth = 0, currentYear = 0;
	int jumpToMonth = 0;
	boolean increment = true;
	
	public void datePicker2() {
		String dateToSet = "11/17/2023";
		getCurrentDateMonthAndYear();
		System.out.println(currentDay + " " + currentMonth +" " + currentYear);
		getTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay + " " + targetMonth + " " + targetYear);
		calculateHowManyMonthsToJump();
		System.out.println(jumpToMonth);
		
		WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"));
		datePickerBtn.click();
		driver = driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		
		for(int i= 0; i < jumpToMonth; i++) {
			if(increment) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
				
			}else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
				increment = false;
			}
			delay(2);
		}
			driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		}
		
		
	
	
	public  void calculateHowManyMonthsToJump() {
		if((targetMonth-currentMonth)>0) {
			jumpToMonth = targetMonth-currentMonth;
		}else {
			jumpToMonth = currentMonth-targetMonth;
			increment = false;
		}
	}
	public  void getTargetDateMonthAndYear(String dateToSet) {
		int firstIndex = dateToSet.indexOf("/");
		int lastIndex = dateToSet.lastIndexOf("/");
		String day = dateToSet.substring(0,firstIndex);
		String month = dateToSet.substring(firstIndex + 1,lastIndex);
		String year = dateToSet.substring(lastIndex +1, dateToSet.length());
		targetDay = Integer.parseInt(day);
		targetMonth = Integer.parseInt(month);
		targetYear = Integer.parseInt(year);
	}
	public  void getCurrentDateMonthAndYear() {
		Calendar calendar = Calendar.getInstance();
		currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		currentMonth = calendar.get(Calendar.MONTH);
		currentYear = calendar.get(Calendar.YEAR);
	
	}
	@Test(enabled = false) // failed
	public void datePicker4() {
		System.out.println("Step1: locate the datePicker button and click");
		WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"));
		datePickerBtn.click();
		System.out.println("Step2: locate iframe and Switch to iframe");
		driver = driver.switchTo().frame(0);
		
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		System.out.println("Step3: locate the actual month");
		String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		System.out.println("Step4: locate the actual year");
		String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		System.out.println("Step5: pick the date if it is matching get out of the loop");
		while (!(actualMonth.equals("April") && actualYear.equals("2024"))) {
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
		nextBtn.click();
		System.out.println("Step6: if the date isn't match stay in the loop");
		actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		System.out.println("Step7: locate the day and pick number 5 ");
		WebElement day = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a"));
		day.click();
		
		driver = driver.switchTo().defaultContent();
		}
	}
	
	
	@Test(enabled = false)//failed
	public void datePicker3() {
		
		
		System.out.println("Step1: locate the datePicker button and click");
		WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[6]/a"));
		datePickerBtn.click();
		
		driver = driver.switchTo().frame(0);
		WebElement date = driver.findElement(By.id("datepicker"));
		date.click();
		delay(2);
		
		while(true) {
		String pickMount = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
        String pickYear = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
		if (!(pickMount.equals("April")&& pickYear.equals("2024"))) {
        	break;
        }
        else 
        {
        WebElement next =  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
        next.click();
        
        }
	
		}
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a")).click();
		
		driver= driver.switchTo().defaultContent();
		}
	

}
