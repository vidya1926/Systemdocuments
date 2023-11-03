package leaf;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Accounts {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();

		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Vinoth");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Vino");
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Thread.sleep(3000);
		Set<String> handle = driver.getWindowHandles();
		List<String> LSTHand = new ArrayList<String>(handle);
		driver.switchTo().window(LSTHand.get(1));

		driver.findElement(By.xpath("//input[@name='accountName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='13604']")).click();
		driver.switchTo().window(LSTHand.get(0));
		WebElement element = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select SC = new Select(element);
		SC.selectByVisibleText("Computer Software");

		WebElement Ownership = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select ST = new Select(Ownership);
		ST.selectByVisibleText("Partnership");

		WebElement Country = driver.findElement(By.xpath("//select[@id='generalCountryGeoId']"));
		Select Place = new Select(Country);
		Place.selectByVisibleText("India");

		driver.findElement(By.xpath("//input[@value='Create Account']")).click();

	}

}
