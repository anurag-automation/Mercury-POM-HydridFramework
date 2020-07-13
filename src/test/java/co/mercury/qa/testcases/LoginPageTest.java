package co.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FlightFinder;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	FlightFinder flightFinder;
	TestUtil testUtil;

	
	public LoginPageTest() {
		
		super();
		
	}
 
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		
	}
	
	@Test (priority =1)
	
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Welcome: Mercury Tours", "Page title is not as expected");
		
	}
	
	
	@DataProvider
	
	public Object[][] getLoginData(){
		
		Object[][] data = TestUtil.getTestData("Login");
		
		return data;
	}
    @Test (priority =2, dataProvider = "getLoginData")
	
	public void loginTest(String username, String password) {
    	
    	flightFinder = loginPage.login(username, password);
    }
	
	
	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
