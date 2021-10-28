package sapf;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebookpage.LandingPage;
import resources.Base;


public class vTittle extends Base

{
	public WebDriver driver;
	 public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest()

	public void openBrowser() throws IOException

	{
		driver = InitailizeDriver();
		log.info("Driver is Initailizeded");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home Page");
		System.out.println("hello");
		
		System.out.println("Rahul");
		
		System.out.println("very GoodMorning");
	}

	@Test
	public void validatetext()

	{
		LandingPage lpage = new LandingPage(driver);
		Assert.assertTrue(lpage.Text().isDisplayed());
		Assert.assertEquals(lpage.Text().getText(), "Create a Page for a celebrity, band or business.");
		log.info("successfully displayed text message");
		
		System.out.println("successfully displayed text message");

	}

	@AfterTest
	public void closeBrowser()

	{
		driver.close();

	}
}
