package co.mercury.qa.testcases;

import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.BookFlight;
import com.mercury.qa.pages.FlightFinder;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlight;
import com.mercury.qa.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class SelectFlightTest extends TestBase {
	
	LoginPage loginPage;
	FlightFinder flightFinder;
	SelectFlight selectFlight;
	BookFlight bookFlight;
	
	public SelectFlightTest() {
		
		super();
	}
	
	
	@BeforeMethod 

	  public void setUp(Object[] params ) {
		  initialization();
		  loginPage = new LoginPage();
		  flightFinder = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		  flightFinder.flightType("oneway");
		  flightFinder.passCount("3");
		  flightFinder.selectDepartingCity("New York");
		  flightFinder.selectFromMonth("July");
		  flightFinder.selectFromDay("28");
		  flightFinder.selectArrivalCity("Paris");
		  flightFinder.selectToMonth("August");
		  flightFinder.selectToDay("5");
		  flightFinder.serviceClass("Business");
		  flightFinder.selectAirline("Unified Airlines");
		  selectFlight = flightFinder.submitFlightFinderForm();
	  }
	
	
 
  
  @DataProvider
	
  public Object[] getSelectFlightTestData() {
  		
  		
  		Object[][] data = TestUtil.getTestData("SelectFlight");

  return data;
  	}
  @Test (priority =1, dataProvider = "getSelectFlightTestData")
  
  public void verifySelectFlight(String depart, String returnFlt) {
	  
	 selectFlight.OutflightSelection(depart);
	 selectFlight.returnflightSelection(returnFlt);
	 bookFlight = selectFlight.reserveFlight();
  }
  
 
 
  

  @AfterMethod
  public void tearDown() {
	  
	 driver.quit();
  }

}
