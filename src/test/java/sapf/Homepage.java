package sapf;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import facebookpage.loginpage;
import resources.Base;


public class Homepage extends Base

{
	public WebDriver driver;
	 public static Logger log = LogManager.getLogger(Base.class.getName());

	 @BeforeTest()

	public void openBrowser() throws IOException {
		driver = InitailizeDriver();

	}

	@Test(dataProvider="getData")
	public void basepagenavigation(String username,String password) throws IOException

	{

		driver.get(prop.getProperty("url"));
		loginpage lp = new loginpage(driver);
	
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
		lp.clickonloginbutton().click();
		log.info("Account is successfully login");
	
	}
	
	@AfterTest
	public void teardown()
	
	{
		driver.close();
		log.info("Driver is successfully closed");
	}


	
	@DataProvider()
	
	public Object[][] getData()
	
	{
		Object[][] data = new Object[2][2];
		data[0][0] =  "sharanpadashetty637@gmail.com";
		data[0][1] = "Padashetty$2110";

		data[1][0] = "8073048760";
		data[1][1] = "Padashetty$2110";
		 
		
		return data;
		
		
	}
}
