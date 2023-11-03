package leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");

		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("CRM/SFA")).click();
		// create contact
		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("Sanjay");
		driver.findElement(By.id("lastNameField")).sendKeys("AV");

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("SANJAY");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(" ");
		driver.findElement(By.id("createContactForm_personalTitle")).sendKeys("AV");
		driver.findElement(By.id("createContactForm_generalProfTitle")).sendKeys("Trainer");
		driver.findElement(By.name("departmentName")).sendKeys("Demo 1");

		WebElement currency = driver.findElement(By.id("createContactForm_preferredCurrencyUomId"));
		Select cur = new Select(currency);
		cur.selectByVisibleText("INR - Indian Rupee");
		driver.findElement(By.id("createContactForm_birthDate")).sendKeys("25/05/1987");

		driver.findElement(By.id("createContactForm_accountPartyId")).sendKeys("12058545");

		driver.findElement(By.id("createContactForm_description")).sendKeys("Tainer for Selenium");
		driver.findElement(By.id("createContactForm_importantNote")).sendKeys("");

		driver.findElement(By.id("createContactForm_primaryPhoneCountryCode")).sendKeys("2");

		driver.findElement(By.id("createContactForm_primaryPhoneAreaCode")).sendKeys("91");
		driver.findElement(By.id("createContactForm_primaryPhoneExtension")).sendKeys("21");

		driver.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys("91369878421");
		driver.findElement(By.id("createContactForm_primaryPhoneAskForName")).sendKeys("vijay");

		driver.findElement(By.id("generalToNameField")).sendKeys("Sanjay");
		driver.findElement(By.id("createContactForm_generalAttnName")).sendKeys("TManager");
		driver.findElement(By.id("createContactForm_generalAddress1")).sendKeys("NO:10 RS APT");
		driver.findElement(By.id("createContactForm_generalAddress2")).sendKeys("Anna Nagar west");
		driver.findElement(By.id("createContactForm_generalCity")).sendKeys("Chennai");

		WebElement generalcountry = driver.findElement(By.id("createContactForm_generalCountryGeoId"));
		new Select(generalcountry).selectByVisibleText("India");
		Thread.sleep(3000);
		WebElement generalSta = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		new Select(generalSta).selectByVisibleText("KARNATAKA");

		/*
		 * WebElement from =
		 * driver.findElement(By.id("createContactForm_generalCountryGeoId"));
		 * 
		 * Select State = new Select(from); List<WebElement> city = State.getOptions();
		 * List<String> get = new ArrayList<String>(); for (int i = 0; i < city.size();
		 * i++) { if (city.get(i).getText().startsWith("k")) {
		 * get.add(city.get(i).getText());
		 * 
		 * }
		 * 
		 * System.out.println(get);
		 * 
		 * }
		 */

		driver.findElement(By.id("createContactForm_generalPostalCode")).sendKeys("600001");

		driver.findElement(By.id("createContactForm_generalPostalCodeExt")).sendKeys("333");

		driver.findElement(By.className("smallSubmit")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);

		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("importantNote")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Can Work delicately");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
}
