package EcommerceSite.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import EcommerceSite.pageobjects.CartPage;
import EcommerceSite.pageobjects.CheckoutPage;
import EcommerceSite.pageobjects.ConfirmationPage;
import EcommerceSite.pageobjects.LandingTest;
import EcommerceSite.pageobjects.Productcatlog;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


	public class StepDefination extends BaseTest{

		public LandingTest landingpage;
		public Productcatlog productcatlog;
		public ConfirmationPage confirmationPage;
		
		@Given(" I landed on the Page!!!!!!!!!!!!!!!!!!!!!! ")
		
		public void landed_on_the_page() throws IOException
		{
			 landingpage=launchApplication();
		}
		
		@Given("^LogIn with (.+) & (.+)$")
		
		public void Login_with_username_password(String name,String password)
		{
			Productcatlog productcatlog=landingpage.LoginAction("sp5561719@gmail.com", "Sourabh@1432");
		}
		@When("^Add the (.+) into cart$")
		public void add_the_product_into_cart(String name) throws InterruptedException
		{
			List<WebElement>item=productcatlog.getProdList();
			productcatlog.addtoCart(name);
		}
		@When ("^checkout (.+) and submit the product$")
		public void Checkout_product_and_submit_product(String name)
		{
			CartPage cartpage=productcatlog.gotoCartPage();
			
			
			Boolean match=cartpage.verifyProductDisplay(name);
			
			Assert.assertTrue(match);
			
			CheckoutPage checkoutpage=cartpage.gotoCheckout();
			checkoutpage.SelectCountry("India");
			ConfirmationPage confirmationPage=	checkoutpage.submitorder();
		}
		@Then("{string} display messege on page")
		public void display_messege_on_page(String string)
		{
			String confirmMessege=confirmationPage.getconfirmationmessege();
			Assert.assertTrue(confirmMessege.equalsIgnoreCase(string));
			
		}
		 @Then("^\"([^\"]*)\" message is displayed$")
		    public void something_message_is_displayed(String strArg1) throws Throwable {
		   
		    	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		    	driver.close();
		    }

}
