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

import EcommerceSite.pageobjects.LandingTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		
		WebDriver driver=WebDriverManager.chromedriver().create();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		LandingTest ab=new LandingTest(driver);
		ab.LoginAction("sp5561719@gmail.com", "Sourabh@1432");
		driver.findElement(By.id("userEmail")).sendKeys("sp5561719@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("Sourabh@1432");
		
		driver.findElement(By.id("login")).click();
		
		
		List<WebElement> item=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement phone=	item.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		
		phone.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		phone.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		WebElement Shoes=item.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findAny().orElse(null);
		
		Thread.sleep(1000);
		
		Shoes.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		
		List<WebElement> carts=driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		
		boolean result=	carts.stream().anyMatch(ProdCart->ProdCart.getText().equalsIgnoreCase("Iphone 13 Pro"));
		
		Assert.assertTrue(result);
		
		Thread.sleep(2000);
		
		WebElement button=	driver.findElement(By.cssSelector(".totalRow button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
		
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		
		String Header=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(Header.equalsIgnoreCase("Thankyou for the order."));
		
		
		
			
		

	
	

	
		Thread.sleep(10000);
		
		
		
	}

}
