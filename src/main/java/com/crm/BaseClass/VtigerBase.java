package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.fileUtility.ReaddFromProperty;
import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

public class VtigerBase 
{
	public static WebDriver driver = null;
	
	@BeforeClass
	public void preConndition() throws IOException
	{
		String browser  = ReaddFromProperty.propertyData("browser");
		String url = ReaddFromProperty.propertyData("url");
		
		// If Else If Ladder
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("internetexplorer"))
		{
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		
		// Maximize The Browser
		driver.manage().window().maximize();
		
		// Implicitly Waiting Condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter The Url
		driver.get(url);
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		String username = ReaddFromProperty.propertyData("username");
		String password = ReaddFromProperty.propertyData("password");
		LoginPage lgn = new LoginPage(driver);
		lgn.userName(username);
		lgn.password(password);
		lgn.submit();
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.profile();
		hp.signOut();
	}
	
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}