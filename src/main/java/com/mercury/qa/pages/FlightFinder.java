package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class FlightFinder extends TestBase {
	
	SelectFlight selectflight;
	
	@FindBy(xpath = "//body//b//input[1]")
	WebElement RoundTrip;
	
	@FindBy(xpath = "//body//b//input[2]")
	WebElement OneWay;
	
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement passCount;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement fromPort;
	
	@FindBy(xpath = "//select[@name='fromMonth']")
	WebElement fromMonth;
	
	@FindBy(xpath = "//select[@name='fromDay']")
	WebElement fromDay;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement toPort;
	
	@FindBy(xpath = "//select[@name='toMonth']")
	WebElement toMonth;
	
	@FindBy(xpath = "//select[@name='toDay']")
	WebElement toDay;
	
	@FindBy(xpath = "//font[contains(text(),'Economy class')]")
	WebElement ecoClass;
	

	@FindBy(xpath = "//font[contains(text(),'Business class')]")
	WebElement busClass;
	
	@FindBy(xpath = "//font[contains(text(),'First class')]")
	WebElement firClass;
	
	@FindBy(xpath = "//select[@name='airline']")
	WebElement airline;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement findFlights;
	
	
	public FlightFinder() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String FlightFinderTitle() {
		return driver.getTitle();
		
	}
	
	public void flightType(String flightType) {
		
		//int a = driver.findElements(By.xpath("//body//b//input[@type='radio']")).size();
		
		//System.out.println("Number of radio buttons are " + a);
		
		//System.out.println("Flight Type Index:" + Integer.parseInt(flightType));
	
		driver.findElement(By.xpath("//body//b//input[@value='"+flightType+"']")).click();
	}
	
public void passCount(String index) {
		
	
		Select count = new Select (driver.findElement(By.xpath("//select[@name='passCount']")));
		
		
			count.selectByVisibleText(index);
	}

public void selectDepartingCity(String departCityName) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='fromPort']")));
	
	
		count.selectByVisibleText(departCityName);
}

public void selectFromMonth(String fromMonth) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='fromMonth']")));
	
	
		count.selectByVisibleText(fromMonth);
}

public void selectFromDay(String fromDay) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='fromDay']")));
	
	
		count.selectByVisibleText(fromDay);
}

public void selectArrivalCity(String arrivalCityName) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='toPort']")));
	
	
		count.selectByVisibleText(arrivalCityName);
}

public void selectToMonth(String toMonth) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='toMonth']")));
	
	
		count.selectByVisibleText(toMonth);
}

public void selectToDay(String toDay) {
	

	Select count = new Select (driver.findElement(By.xpath("//select[@name='toDay']")));
	
	
		count.selectByVisibleText(toDay);
}

public void serviceClass(String index) {
	
	//int a = driver.findElements(By.xpath("//input[@type = 'radio' and @name = 'servClass']")).size();
	
	//System.out.println("Number of radio buttons are " + a);
	
	driver.findElement(By.xpath("//input[@type = 'radio' and @value = '"+index+"']")).click();
	
		
}

public void selectAirline(String index) {
	
	Select airline = new Select(driver.findElement(By.xpath("//select[@name = 'airline']")));
	
	airline.selectByVisibleText(index);
}

public SelectFlight submitFlightFinderForm() {
	
	findFlights.click();
	
	return new SelectFlight();
	
}

}
