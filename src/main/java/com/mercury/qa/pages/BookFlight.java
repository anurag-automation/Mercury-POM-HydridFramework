package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class BookFlight extends TestBase {
	
	public void passengerDetails(String name, String lastName, String meal) {
		
		driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys(lastName);
		
		Select passmeal = new Select(driver.findElement(By.xpath("//select[@name='pass.0.meal']")));
        passmeal.selectByVisibleText(meal);;
	}
	public void creditCardDetails(String cardName, String CardNum, String expDate, String expYear, String chName, String chMiddleName, String chLastname) 
	
	{
		Select creditCard = new Select(driver.findElement(By.xpath("//select[@name='creditCard']")));
        creditCard.selectByVisibleText(cardName);;
		
		driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys(CardNum);
		
		Select ccExpDate = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']")));
        ccExpDate.selectByVisibleText(expDate);
		
		Select ccExpYear = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']")));
		ccExpYear.selectByVisibleText(expYear);
		
		driver.findElement(By.xpath("//input[@name='cc_frst_name']")).sendKeys(chName);

		driver.findElement(By.xpath("//input[@name='cc_mid_name']")).sendKeys(chMiddleName);

		driver.findElement(By.xpath("//input[@name='cc_last_name']")).sendKeys(chLastname);

	}
	
	public void billingAddress(String addLine1,String addLine2, String city, String state, String zip, String country) 
	{
		driver.findElement(By.xpath("//input[@name='billAddress1']")).clear();
		driver.findElement(By.xpath("//input[@name='billAddress1']")).sendKeys(addLine1);
		
		driver.findElement(By.xpath("//input[@name='billAddress2']")).clear();
		driver.findElement(By.xpath("//input[@name='billAddress2']")).sendKeys(addLine2);
		

		driver.findElement(By.xpath("//input[@name='billCity']")).clear();
		driver.findElement(By.xpath("//input[@name='billCity']")).sendKeys(city);
		
		driver.findElement(By.xpath("//input[@name='billState']")).clear();
		driver.findElement(By.xpath("//input[@name='billState']")).sendKeys(state);
		
		driver.findElement(By.xpath("//input[@name='billZip']")).clear();
		driver.findElement(By.xpath("//input[@name='billZip']")).sendKeys(zip);
		
		Select selectCountry = new Select(driver.findElement(By.xpath("//select[@name='billCountry']")));
		selectCountry.selectByVisibleText(country);
		
	}
	
	public FlightConfirmation buyFlights() {
		
		driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
		
		return new FlightConfirmation();

	}
		
	}

