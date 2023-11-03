package learnSelenium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class learning {

	
	
	
		public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	driver.get("https://www.instagram.com/accounts/emailsignup/");
		Thread.sleep(3000);
		WebElement findElement = driver.findElement(By.xpath("//input[contains(@name,'emailOrPhone')]"));
		findElement.sendKeys("9992030320");
		driver.findElement(By.name("fullName")).sendKeys("Vidya");
		driver.findElement(By.name("username")).sendKeys("vidyaksan");
		driver.findElement(By.name("password")).sendKeys("vidyaksan");

		
		
		
		
		
		
		
		
		}

}
