package com.procure360;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class ExistingUserLogin {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties dataProperties = new Properties();
		FileInputStream fs = new FileInputStream(
				"D:\\Automation\\Procure360\\src\\main\\java\\com\\procure360\\DataProvider.properties");
		dataProperties.load(fs);
		/*
		 * String url1 = dataProperties.getProperty("URL"); System.out.println(url1);
		 */
		String browsername = dataProperties.getProperty("Browser");
		System.out.println(browsername);// chrome
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		String url = dataProperties.getProperty("URL");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		String CreateNow = driver.findElement(By.xpath(dataProperties.getProperty("CreateNow_Xpath"))).getText();
		if (CreateNow.equals("Create now!")) {
			System.out.println("Create now option is available in the user login page");
		} else {
			System.out.println("The link is not present");
		}

		driver.findElement(By.xpath(dataProperties.getProperty("Username_Xpath")))
				.sendKeys(dataProperties.getProperty("UserName"));
		driver.findElement(By.xpath(dataProperties.getProperty("Next_Xpath"))).click();
		driver.findElement(By.xpath(dataProperties.getProperty("Password_Xpath")))
				.sendKeys(dataProperties.getProperty("Password"));
		driver.findElement(By.xpath(dataProperties.getProperty("Submit_Xpath"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (dataProperties.getProperty("UserName").equals("sekar")) {
			String badcredentials = driver
					.findElement(By.xpath(dataProperties.getProperty("Invlaidusername&Password_Xpath"))).getText();
			System.out.println(badcredentials);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[starts-with(@class,'fa fa')]")).click();
			driver.findElement(By.xpath(dataProperties.getProperty("Username_Xpath")))
					.sendKeys(dataProperties.getProperty("UserName"));
			driver.findElement(By.xpath(dataProperties.getProperty("Next_Xpath"))).click();
			driver.findElement(By.xpath(dataProperties.getProperty("Password_Xpath")))
					.sendKeys(dataProperties.getProperty("Password"));
			driver.findElement(By.xpath(dataProperties.getProperty("Submit_Xpath"))).click();
		} else {
			System.out.println("Supplier successfully logged into the application");
		}
		// Logo
		Boolean Logo = driver.findElement(By.xpath(dataProperties.getProperty("Logo_icon_Xpath"))).isDisplayed();
		System.out.println("Procure 360 logo is present:" + Logo);
		// Page Title
		System.out.println("Page title is :" + driver.getTitle());
		// Menu icon
		Boolean Menuicon = driver.findElement(By.xpath(dataProperties.getProperty("Menu_icon_Xpath"))).isDisplayed();
		System.out.println("Menu option is present in the header section:" + Menuicon);
		// Home icon
		Boolean Homeicon = driver.findElement(By.xpath(dataProperties.getProperty("Home_icon_Xpath"))).isDisplayed();
		System.out.println("Home option is present in the header section:" + Homeicon);
		// Contact_us icon
		Boolean Contactus = driver.findElement(By.xpath(dataProperties.getProperty("contactUs_icon_Xpath")))
				.isDisplayed();
		System.out.println("Contact us option is present in the header section:" + Contactus);
		// Logout option
		Boolean Logout = driver.findElement(By.xpath(dataProperties.getProperty("Logout_icon_Xpath"))).isDisplayed();
		System.out.println("Logout option is present in the header section:" + Logout);
		// Arabic
		Boolean Arabic = driver.findElement(By.xpath(dataProperties.getProperty("Arabic_Translation_Xpath")))
				.isDisplayed();
		System.out.println("Arabic translation option is present in the header section:" + Arabic);
		String PageHeder = driver.findElement(By.xpath(dataProperties.getProperty("Welcome_Message_Xpath"))).getText();
		System.out.println(PageHeder);
		driver.findElement(By.xpath(dataProperties.getProperty("Supplier_Registration_Xpath"))).click();
		// First time user check

		/*
		 * String status =
		 * driver.findElement(By.xpath(dataProperties.getProperty("Sub_Status_Xpath"))).
		 * getText(); if (status.equals("Completed")) {
		 * driver.findElement(By.xpath(dataProperties.getProperty("View_Xpath"))).click(
		 * ); } else {
		 * driver.findElement(By.xpath(dataProperties.getProperty("Edit_Xpath"))).click(
		 * ); }
		 */
		System.out.println("User Navigated into the Supplier information section");
		System.out.println("Supplier Information");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String CompanynameinEnglish = driver
				.findElement(By.xpath(dataProperties.getProperty("CompanyNameEnglish_Xpath"))).getText();
		System.out.println(CompanynameinEnglish);
		driver.findElement(By.xpath(dataProperties.getProperty("CompanyNameArbic_Xpath")))
				.sendKeys(dataProperties.getProperty("ArabicCompanyname"));
		Select Ownership = new Select(driver.findElement(By.xpath("//*[@name='ownerTypeValue']")));
		Ownership.selectByVisibleText("Joint Venture");
		System.out.println("************* drop down *************");
		System.out.println(driver.findElement(By.xpath("//*[@name='ownerTypeValue']")).getText());
		Select SupplierType = new Select(
				driver.findElement(By.xpath(dataProperties.getProperty("SupplierType_Xpath"))));
		SupplierType.selectByVisibleText("Investor");
		Thread.sleep(3000);
		driver.findElement(By.xpath(dataProperties.getProperty("OrgWebsite_Xpath")))
				.sendKeys(dataProperties.getProperty("OrgWebsite"));
		// cal icon
		Screen cal = new Screen();
		Pattern icon = new Pattern("D:\\Eclipse\\Eclipseworks\\Flipkart-Devonsoftware\\360_Cal.png");
		cal.wait(icon, 1000);
		cal.click();

		Screen establishdate = new Screen();
		Pattern ED = new Pattern("D:\\Eclipse\\Eclipseworks\\Flipkart-Devonsoftware\\360_Establishdate.png");
		establishdate.wait(ED, 1000);
		establishdate.click();

		// // establishment date
		driver.findElement(By.xpath(dataProperties.getProperty("ParenCompanyName_Xpath")))
				.sendKeys(dataProperties.getProperty("ParentCompanyname"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); // vertical scroll
		/*
		 * WebElement element =driver.findElement(By.xpath("//input [@id=�email�]"));
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
		 * element); // horizontal scroll
		 */
		driver.findElement(By.xpath(dataProperties.getProperty("IssuedBy_Xpath")))
				.sendKeys(dataProperties.getProperty("Issuedby"));
		// Issued date


		driver.findElement(By.xpath(dataProperties.getProperty("Location_Xpath")))
				.sendKeys(dataProperties.getProperty("Location"));
		// Expiry date
		Boolean checkbox = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
		System.out.println("Check box is selected : " + checkbox);
		driver.findElement(By.xpath(dataProperties.getProperty("Managername_Xpath")))
				.sendKeys(dataProperties.getProperty("ManagerName"));
		driver.findElement(By.xpath(dataProperties.getProperty("JobTitle_Xpath")))
				.sendKeys(dataProperties.getProperty("JobTitle"));
		driver.findElement(By.xpath(dataProperties.getProperty("MobileNUmber_Xpath")))
				.sendKeys(dataProperties.getProperty("MobileNumber"));
		driver.findElement(By.xpath(dataProperties.getProperty("email_Xpath")))
				.sendKeys(dataProperties.getProperty("email"));
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.xpath(dataProperties.getProperty(
		 * "SupplierinfoSave_Xpath"))).click(); String confirmationpopup =
		 * driver.switchTo().alert().getText();
		 * System.out.println("Confirmation pop-up text is :" + confirmationpopup);
		 */

		/*
		 * Screen expirydate = new Screen(); Pattern ExD = new Pattern(
		 * "D:\\Eclipse\\Eclipseworks\\Flipkart-Devonsoftware\\360_ExpiryDate.png");
		 * expirydate.wait(ExD,1000); expirydate.click();
		 */

	}

}
