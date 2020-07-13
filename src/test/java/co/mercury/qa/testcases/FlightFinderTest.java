package co.mercury.qa.testcases;


import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FlightFinder;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlight;
import com.mercury.qa.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FlightFinderTest extends TestBase{
	
	LoginPage loginPage;
	FlightFinder flightFinder;
	SelectFlight selectFlight;
	
	public FlightFinderTest() {
		
		super();
	}

	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		
		loginPage = new LoginPage();
		
		flightFinder = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	
	public void verifyFlightFinderTitle() {
		
		String title = flightFinder.FlightFinderTitle();
		
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:", "Title did not match");
		
	}
	
	
	@DataProvider
	
	public Object[][] getTestData(){
		
		Object[][] data = TestUtil.getTestData("FlightFinder");
		
		return data;
		
	}
	
	@Test (priority =2, dataProvider = "getTestData")
public void flightFinderForm(String flightType, String passCount,String departingCity, String fromMonth, 
		
	String fromDay, String arrivalCity, String toMonth, String toDay, String serviceClass, String airline ) {
		
		flightFinder.flightType(flightType);
		flightFinder.passCount(passCount);
		flightFinder.selectDepartingCity(departingCity);
		flightFinder.selectFromMonth(fromMonth);
		flightFinder.selectFromDay(fromDay);
		flightFinder.selectArrivalCity(arrivalCity);
		flightFinder.selectToMonth(toMonth);
		flightFinder.selectToDay(toDay);
		flightFinder.serviceClass(serviceClass);
		flightFinder.selectAirline(airline);
		selectFlight = flightFinder.submitFlightFinderForm();
	}

	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}

}
