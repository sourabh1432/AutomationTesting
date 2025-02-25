package EcommerceSite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceSite.AbstractComp.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	

	WebDriver driver;
	
	
	//WebElement button=	driver.findElement(By.cssSelector(".totalRow button"));
	@FindBy(css=".totalRow button")
	WebElement CheckoutEle;
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	private List<WebElement> cartproducts;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String name)
	{
		boolean match=	cartproducts.stream().anyMatch(ProdCart->ProdCart.getText().equalsIgnoreCase(name));
		return match;
	}
	
	public CheckoutPage gotoCheckout()
	{
		CheckoutEle.click();
		return new CheckoutPage(driver);
	}
	
	

}
