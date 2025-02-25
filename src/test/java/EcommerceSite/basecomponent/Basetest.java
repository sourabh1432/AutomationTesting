package EcommerceSite.basecomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	WebDriver driver;
	
	public void inilizebrowser() throws IOException {
	
	Properties pr=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Sourabh\\eclipse-workspace\\EcommerceSite\\src\\main\\java\\EcommerceSite\\resourse");
	pr.load(fis);
	String Browsername=pr.getProperty("browser");
	
	
	if(Browsername.equals("chrome"))
	{
	
	
	WebDriverManager.chromedriver().create();
	
	
	}
	else if(Browsername.equals("Edge"))
	{
		WebDriverManager.edgedriver().create();
		
	}
	else if(Browsername.equals("Firefox"))
	{
		WebDriverManager.firefoxdriver().create();
		
		
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.manage().window().maximize();
	}

}
