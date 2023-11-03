package leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Findoppurtunity {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@class='inputLogin']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.findElement(By.xpath("//div[@id='label']//a[1]")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/opportunitiesMain']")).click();
		// driver.findElement(By.xpath("//div[@class='x-grid3-header-offset']//table"));
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[3]")).click();

		driver.findElement(By.xpath("(//input[@name='opportunityName'])[2]")).sendKeys("Vikram");

		String t1 = driver.getTitle();
		System.out.println(t1);

		driver.findElement(By.xpath("//a[text()='10001']")).click();


	}

}
