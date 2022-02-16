package com.procure360;



import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewUserLogin {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		Properties dataProperties = new Properties();
		FileInputStream fs = new FileInputStream(
				"D:\\Automation\\Procure360\\src\\main\\java\\com\\procure360\\DataProvider.properties");
		dataProperties.load(fs);
		String browsername = dataProperties.getProperty("Browser");
		System.out.println(browsername);// chrome
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.egecko.driver", "D:\\Jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		String url = dataProperties.getProperty("URL");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath(dataProperties.getProperty("CreateNow_Xpath"))).click();
		System.out.println("*************User Navigated into new user registration section***********");
		Boolean submitbutton = driver.findElement(By.xpath(dataProperties.getProperty("SubmitButton_Xpath"))).isEnabled();
		if(submitbutton.equals(false))
		{
		System.out.println("Submit button is not enabled");
		}
		else
		System.out.println("Submit button is enabled");
		driver.findElement(By.xpath(dataProperties.getProperty("CompanyName_Xpath"))).sendKeys(dataProperties.getProperty("Companyname"));
		//driver.findElement(By.xpath(dataProperties.getProperty("CompanyName_Xpath"))).clear();
		driver.findElement(By.name(dataProperties.getProperty("TradeLicence_Name"))).sendKeys(dataProperties.getProperty("TradeLicenceNo"));
		driver.findElement(By.xpath(dataProperties.getProperty("FirstName_Xpath"))).sendKeys(dataProperties.getProperty("Firstname"));
		driver.findElement(By.xpath(dataProperties.getProperty("MiddleName_Xpath"))).sendKeys(dataProperties.getProperty("Middlename"));
		driver.findElement(By.xpath(dataProperties.getProperty("LastName_Xpath"))).sendKeys(dataProperties.getProperty("Lastname"));
		driver.findElement(By.xpath(dataProperties.getProperty("Designation_Xpath"))).sendKeys(dataProperties.getProperty("job/designation"));
		driver.findElement(By.xpath(dataProperties.getProperty("Phonenumber_Xpath"))).sendKeys(dataProperties.getProperty("Phonenumber"));
		driver.findElement(By.xpath(dataProperties.getProperty("Email_Xpath"))).sendKeys(dataProperties.getProperty("email"));
		driver.findElement(By.name(dataProperties.getProperty("Userid_Name"))).sendKeys(dataProperties.getProperty("Userid"));
		driver.findElement(By.xpath(dataProperties.getProperty("LoginPassword_Xpath"))).sendKeys(dataProperties.getProperty("Password"));
		driver.findElement(By.xpath(dataProperties.getProperty("ConfirmPassword_Xpath"))).sendKeys(dataProperties.getProperty("Confirmpassword"));
		
		Boolean submitbutton1 = driver.findElement(By.xpath(dataProperties.getProperty("SubmitButton_Xpath"))).isEnabled();
		if(submitbutton1.equals(false))
		{
		System.out.println("Submit button is not enabled");
		}
		else
		System.out.println("After entering user details Submit button is enabled");
		driver.findElement(By.xpath(dataProperties.getProperty("ClearButton_Xpath"))).click();
		driver.findElement(By.xpath(dataProperties.getProperty("CompanyName_Xpath"))).sendKeys(dataProperties.getProperty("Companyname"));
		//driver.findElement(By.xpath(dataProperties.getProperty("CompanyName_Xpath"))).clear();
		driver.findElement(By.name(dataProperties.getProperty("TradeLicence_Name"))).sendKeys(dataProperties.getProperty("TradeLicenceNo"));
		driver.findElement(By.xpath(dataProperties.getProperty("FirstName_Xpath"))).sendKeys(dataProperties.getProperty("Firstname"));
		driver.findElement(By.xpath(dataProperties.getProperty("MiddleName_Xpath"))).sendKeys(dataProperties.getProperty("Middlename"));
		driver.findElement(By.xpath(dataProperties.getProperty("LastName_Xpath"))).sendKeys(dataProperties.getProperty("Lastname"));
		driver.findElement(By.xpath(dataProperties.getProperty("Designation_Xpath"))).sendKeys(dataProperties.getProperty("job/designation"));
		driver.findElement(By.xpath(dataProperties.getProperty("Phonenumber_Xpath"))).sendKeys(dataProperties.getProperty("Phonenumber"));
		driver.findElement(By.xpath(dataProperties.getProperty("Email_Xpath"))).sendKeys(dataProperties.getProperty("email"));
		driver.findElement(By.name(dataProperties.getProperty("Userid_Name"))).sendKeys(dataProperties.getProperty("Userid"));
		driver.findElement(By.xpath(dataProperties.getProperty("LoginPassword_Xpath"))).sendKeys(dataProperties.getProperty("Password"));
		driver.findElement(By.xpath(dataProperties.getProperty("ConfirmPassword_Xpath"))).sendKeys(dataProperties.getProperty("Confirmpassword"));
		driver.findElement(By.xpath(dataProperties.getProperty("SubmitButton_Xpath"))).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String Alertmessage = driver.switchTo().alert().getText();
		System.out.println("Alert message is" +Alertmessage);
		if(Alertmessage.equals("User Registered Successfully!"))
		{
		driver.switchTo().alert().accept();
		}
		else
		{
			System.out.println("User not able to register");
		}
		driver.navigate().to(url);
		driver.findElement(By.xpath(dataProperties.getProperty("Username_Xpath"))).sendKeys(dataProperties.getProperty("UserName"));
		driver.findElement(By.xpath(dataProperties.getProperty("Next_Xpath"))).click();
		driver.findElement(By.xpath(dataProperties.getProperty("Password_Xpath"))).sendKeys(dataProperties.getProperty("Password"));
		driver.findElement(By.xpath(dataProperties.getProperty("Submit_Xpath"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dataProperties.getProperty("Supplier_Registration_Xpath"))).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("************* Supplier Information **************");
		String companyname = driver.findElement(By.xpath(dataProperties.getProperty("CompanyNameEnglish_Xpath"))).getText();
		if(companyname.equals("Companyname"))
		{
			System.out.println("Company name fetched from user regidtration screen");
		}
		else
		{
			System.out.println("Company name is not fetched/incorrect");
		}
		driver.findElement(By.xpath(dataProperties.getProperty("CompanyNameArbic_Xpath"))).sendKeys(dataProperties.getProperty("ArabicCompanyname"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 Select Ownership = new Select(driver.findElement(By.xpath("//*[@name='ownerTypeValue']")));
		 Ownership.selectByVisibleText("Joint Venture");
		 System.out.println("************* Ownership*************");
		 System.out.println(driver.findElement(By.xpath("//*[@name='ownerTypeValue']")).getText());
		 System.out.println("************ Supplier Type ***********");
		 Select SupplierType = new Select(driver.findElement(By.xpath(dataProperties.getProperty("//*[@name='quadAreaValue']"))));
		 SupplierType.selectByVisibleText("Investor");
		 System.out.println(driver.findElement(By.xpath(dataProperties.getProperty("//*[@name='quadAreaValue']"))).getText());
		 driver.findElement(By.xpath(dataProperties.getProperty("//*[@name='supplierInfoVO.website']"))).sendKeys(dataProperties.getProperty("OrgWebsite"));
		 
		 
		
		
		
		
	}

}
