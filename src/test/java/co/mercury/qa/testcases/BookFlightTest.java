package co.mercury.qa.testcases;

import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.BookFlight;
import com.mercury.qa.pages.FlightConfirmation;
import com.mercury.qa.pages.FlightFinder;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlight;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BookFlightTest extends TestBase {
	
	LoginPage loginPage;
	FlightFinder flightFinder;
	FlightFinderTest flightFinderTest;
	SelectFlight selectFlight;
	BookFlight bookFlight;
	FlightConfirmation flightConfirmation;
	
	public BookFlightTest() {
		
		super();
	}

  @BeforeMethod
  public void setUp() {
	  
	  initialization();
	  loginPage = new LoginPage();
	  flightFinder = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  flightFinder.flightType(1);
		flightFinder.passCount(3);
		flightFinder.selectDepartingCity("New York");
		flightFinder.selectFromMonth("August");
		flightFinder.selectFromDay("28");
		flightFinder.selectArrivalCity("Paris");
		flightFinder.selectToMonth("October");
		flightFinder.selectToDay("10");
		flightFinder.serviceClass(2);
		flightFinder.selectAirline(2);
		selectFlight = flightFinder.submitFlightFinderForm();
		selectFlight.OutflightSelection(2);
		selectFlight.returnflightSelection(1);
		bookFlight = selectFlight.reserveFlight();
  }

  @Test
  public void verifyBookFlight() {
	  
	  bookFlight.passengerDetails("Anurag", "Verma", "Hindu");
	  bookFlight.creditCardDetails("Visa", "123456789", "10", "2010", "Anurag", "K", "Verma");
	  bookFlight.billingAddress("Flat 201, Central Park", "Beverly Hills", "New York", "New York", "45678", "UGANDA");
	  bookFlight.buyFlights();
  }
  
  
  @AfterMethod
  public void tearDown() {
	  
	  //driver.quit();
  }

}
