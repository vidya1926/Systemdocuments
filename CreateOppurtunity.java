package leaf;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOppurtunity {
	public static void main(String[] args) throws InterruptedException {

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
		driver.findElement(By.xpath("//a[text()='Create Opportunity']")).click();
		driver.findElement(By.id("createOpportunityForm_opportunityName")).sendKeys("Vikram");
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Set<String> handles1 = driver.getWindowHandles();
		List<String> handle1 = new ArrayList<String>(handles1);
		driver.switchTo().window(handle1.get(1));

		driver.findElement(By.xpath("//input[@name='id']")).click();
		driver.findElement(By.xpath("(//label[text()='Account ID:']//following::input)[1]")).sendKeys("DemoAccount1",
				Keys.ENTER);

		driver.findElement(By.xpath("//a[text()='DemoAccount1']")).click();
		driver.switchTo().window(handle1.get(0));
		/*
		 * driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).
		 * click();
		 * 
		 * Set<String> handles2 = driver.getWindowHandles(); List<String> handle2 = new
		 * ArrayList<String>(handles2); driver.switchTo().window(handle2.get(1));
		 * driver.findElement(By.
		 * xpath("(//label[text()='First name:']//following::input)[1]")).sendKeys(
		 * "Babu", Keys.ENTER);
		 * driver.findElement(By.xpath("//a[text()='10765']")).click();
		 * driver.switchTo().window(handle2.get(0));
		 * driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[3]")).
		 * click();
		 * 
		 * Set<String> handles3 = driver.getWindowHandles(); List<String> handle3 = new
		 * ArrayList<String>(handles3); driver.switchTo().window(handle3.get(1));
		 * driver.findElement(By.
		 * xpath("(//label[text()='First name:']//following::input)[1]")).sendKeys(
		 * "Hari", Keys.ENTER);
		 * driver.findElement(By.xpath("//a[text()='15313']")).click();
		 * driver.switchTo().window(handle3.get(0));
		 */

		WebElement initialstage = driver.findElement(By.xpath("//select[@name='opportunityStageId']"));
		Select initial = new Select(initialstage);
		initial.selectByVisibleText("Proposal");

		driver.findElement(By.xpath("(//input[@name='estimatedAmount'])[2]")).sendKeys("200000");

		WebElement Campagain = driver.findElement(By.xpath("//select[@name='marketingCampaignId']"));
		Select MKTCampagain = new Select(Campagain);
		MKTCampagain.selectByVisibleText("Automobile");

		driver.findElement(By.xpath("(//input[@name='estimatedCloseDate'])[2]")).sendKeys("01/20/2023");

		WebElement Type = driver.findElement(By.xpath("//select[@name='typeEnumId']"));
		Select SaleType = new Select(Type);
		SaleType.selectByVisibleText("Upgrade");

		WebElement Currency = driver.findElement(By.xpath("//select[@name='currencyUomId']"));
		Select Currencytype = new Select(Currency);
		Currencytype.selectByValue("INR");

		WebElement Source = driver.findElement(By.xpath("//select[@name='dataSourceId']"));
		Select Sourcetype = new Select(Source);
		Sourcetype.selectByVisibleText("Conference");

		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Automobile Sales");

		driver.findElement(By.xpath("//input[@value='Create Opportunity']")).click();

		driver.findElement(By.xpath("//a[text()='View']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		WebElement element = driver.findElement(By.xpath("//textarea[@name='description']"));
		element.clear();
		element.sendKeys("Demo Sales Manager");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		

	}

}
