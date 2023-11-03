package leaf;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Findcontact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Find Contacts")).click();
		// email tab
		driver.findElement(By.xpath("(//em[@class='x-tab-left'])[3]")).click();

		// email input
		driver.findElement(By.xpath("//label[text()='Email Address:']//following::input")).sendKeys("Test@gmail.com");

		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(5000);

		// driver.findElement(By.cssSelector("div#findContacts>div>div>div>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>div>div>div>div>div>div>div:nth-of-type(2)>div>div>table>tbody>tr>td:nth-of-type(3)>div>a")).click();
		driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewContact?partyId=14192'])[3]")).click();

		WebElement firstname = driver.findElement(By.id("viewContact_firstName_sp"));

		System.out.println(firstname.getText());

		driver.findElement(By.linkText("Edit")).click();

		WebElement update = driver.findElement(By.id("addMarketingCampaignForm_marketingCampaignId"));
		Select add = new Select(update);
		add.selectByValue("9000");

		driver.findElement(By.id("updateContactForm_departmentName")).clear();
		driver.findElement(By.id("updateContactForm_departmentName")).sendKeys("Selenium Automation Testing");

		System.out.println("eCommerce Site Internal Campaign (9000)");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String title1 = driver.getTitle();
		System.out.println(title1);

	}
}