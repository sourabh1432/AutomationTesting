package EcommerceSite.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceSite.AbstractComp.AbstractComponent;

public class Productcatlog extends AbstractComponent {
	
	WebDriver driver;
	
	public Productcatlog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	//List<WebElement> item=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> item;
	
	@FindBy(css="waitForDisappear")
	WebElement spinner;
	
	By item1=By.cssSelector(".mb-3");
	By addToCart=(By.cssSelector(".card-body button:last-of-type"));
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProdList()
	{
		waitForElement(item1);
		return item;
	}
	
	public WebElement getProductByName(String productname)
	{
		WebElement phone=	getProdList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		return phone;
	}
	
	public void addtoCart(String name) throws InterruptedException
	{
		WebElement ab=getProductByName(name);
		ab.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElement(toastMessage);
		waitForDisappear(spinner);
	}

}
