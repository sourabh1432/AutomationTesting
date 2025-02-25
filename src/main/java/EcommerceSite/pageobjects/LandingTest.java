package EcommerceSite.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceSite.AbstractComp.AbstractComponent;

public class LandingTest extends AbstractComponent {

	WebDriver driver;
	
	public LandingTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="userEmail")
	WebElement Username;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public Productcatlog LoginAction(String email,String Pass)
	{
		Username.sendKeys(email);
		Password.sendKeys(Pass);
		login.click();
		Productcatlog productcatlog=new Productcatlog(driver);
		return productcatlog;
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void gotoURL()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
