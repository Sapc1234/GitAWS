package facebookpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 

{
  public WebDriver driver;
By username = By.xpath("//input[@name='email']");
By pass = By.cssSelector("#pass");

@FindBy(xpath = "//button[@name='login']")
WebElement click;




public loginpage(WebDriver driver) 

{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}



public WebElement emailid()

{
	return driver.findElement(username);
}

public WebElement password()

{
	return driver.findElement(pass);
}

public WebElement clickonloginbutton()

{
	return click;
}



}
