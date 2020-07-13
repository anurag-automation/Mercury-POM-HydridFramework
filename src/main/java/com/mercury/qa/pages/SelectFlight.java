package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mercury.qa.base.TestBase;

public class SelectFlight extends TestBase {
	

	
	public void OutflightSelection(String index) {
		
		//int a = driver.findElements(By.xpath("//input[@type='radio' and @name = 'outFlight']")).size();
		
		//System.out.println("Number of radio buttons for Out Flight " + a);
		
		driver.findElement(By.xpath("//input[@type='radio' and @value = '"+index+"']")).click();
		
	}
	
public void returnflightSelection(String index) {
		
		//int a = driver.findElements(By.xpath("//input[@type='radio' and @name = 'inFlight']")).size();
		
		//System.out.println("Number of radio buttons for return Flight " + a);
		
       driver.findElement(By.xpath("//input[@type='radio' and @name='inFlight' and @value = '"+index+"']")).click();

	}

public BookFlight reserveFlight() {
	
	driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
    
	return new BookFlight();

}


}
