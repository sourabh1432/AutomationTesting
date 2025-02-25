package EcommerceSite.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import EcommerceSite.pageobjects.CartPage;
import EcommerceSite.pageobjects.CheckoutPage;
import EcommerceSite.pageobjects.ConfirmationPage;
import EcommerceSite.pageobjects.LandingTest;
import EcommerceSite.pageobjects.Productcatlog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		
		String name="ZARA COAT 3";
		WebDriver driver=WebDriverManager.chromedriver().create();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingTest landingpage=new LandingTest(driver);
		landingpage.gotoURL();
	
	    Productcatlog productcatlog=landingpage.LoginAction("sp5561719@gmail.com", "Sourabh@1432");
		
		//Productcatlog abc=new Productcatlog(driver);
		List<WebElement>item=productcatlog.getProdList();
		productcatlog.addtoCart(name);
		CartPage cartpage=productcatlog.gotoCartPage();
		
		
		Boolean match=cartpage.verifyProductDisplay(name);
		
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage=cartpage.gotoCheckout();
		checkoutpage.SelectCountry("India");
		ConfirmationPage confirmationPage=	checkoutpage.submitorder();
		String confirmMessege=confirmationPage.getconfirmationmessege();
		Assert.assertTrue(confirmMessege.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		Thread.sleep(5000);
		

		
		
		}

}
