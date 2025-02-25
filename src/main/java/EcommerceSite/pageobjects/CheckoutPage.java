package EcommerceSite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import EcommerceSite.AbstractComp.AbstractComponent;

public class CheckoutPage extends  AbstractComponent{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement submit;
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement SelectCountry;
	
	
	public void SelectCountry(String countryname)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Country,countryname).build().perform();
		
		waitForElement(By.cssSelector(".ta-results"));
		SelectCountry.click();
	}

	public ConfirmationPage submitorder()
	{
		submit.click();
		return new ConfirmationPage(driver);
dfdfjfdffk

	}
}
