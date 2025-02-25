package EcommerceSite.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import EcommerceSite.basecomponent.Basetest;
import TestComponents.Retry;
import EcommerceSite.pageobjects.CartPage;
import EcommerceSite.pageobjects.Productcatlog;
import TestComponents.BaseTest;
import junit.framework.Assert;

public class ErrorValidationsTest extends BaseTest{
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		landingPage.LoginAction("sp556545419@gmail.com", "mourabh@1432");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		Productcatlog productCatalogue;
		productCatalogue = landingPage.LoginAction("sp5561719@gmail.com", "Sourabh@1432");
		List<WebElement> products = productCatalogue.getProdList();
		productCatalogue.addtoCart(productName);
		CartPage cartPage = productCatalogue.gotoCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}



