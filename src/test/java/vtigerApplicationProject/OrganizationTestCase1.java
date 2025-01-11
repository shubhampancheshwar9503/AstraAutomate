package vtigerApplicationProject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrganizationTestCase1
{
	@Test
	public void organization()
	{
		// Random
		Random r = new Random();
		
		// New Value Generator
		int value = r.nextInt();
		System.out.println(value);
		
		// New Value Generator Concat With Static Data
		String org_name = "ShubhamPalace"+value;
		
		// Expected Login Url
		String expected_login_url = "http://localhost:8888/index.php?action=index&module=Home";
		
		// Precondition
		// Launched The Browser
//		ChromeDriver driver = new ChromeDriver();
		
		// Upcasting
		WebDriver driver = new ChromeDriver();
		
		// Maximize The Browser
		driver.manage().window().maximize();
		
		// Minimize The Browser
//		driver.manage().window().minimize();
		
		//  Impicitly Waiting Condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter The Url
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
//		driver.navigate().to("http://localhost:8888/index.php?action=index&module=Home");
		
		// Actual Login Url
		String actual_login_url = driver.getCurrentUrl();
		
		// Assert True For Verification
		assertTrue(actual_login_url.contains(actual_login_url),"I Am Not In Login Page");
		
		System.out.println("I Am In Login Page");
		
		// Login
		// Send Keys
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		// Send Keys
		driver.findElement(By.name("user_password")).sendKeys("root");
		
		// Click
		driver.findElement(By.id("submitButton")).click();
	
		WebElement home = driver.findElement(By.className("hdrLink"));
		
		// Assert True For Verification
		assertTrue(home.isDisplayed(),"Home Is Not Displayed");
		
		System.out.println("Home Is Displayed");
	
		WebElement organization = driver.findElement(By.xpath("//a[text()='Organizations']"));
		
		// Assert True For Verification
		assertTrue(organization.isEnabled(),"Organzation Is Not Enabled");
		
		System.out.println("Organization Is Enabled");
	
		// Click Action
		organization.click();
		
		// Click Action
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		// Send Keys
		driver.findElement(By.name("accountname")).sendKeys(org_name);
		
		// Click Action
		driver.findElement(By.cssSelector(".crmbutton.small.save")).click();
		
		WebElement organization_name = driver.findElement(By.className("dvHeaderText"));
		
		// Get Text
		String organization_text = organization_name.getText();
		
		// Assert True For Verification
		assertTrue(organization_text.contains(org_name),"Organization Name Is Not Successfully Created");
		
		System.out.println("Organization Name Is Successfully Created");
		
		// Logout
		// Click Action
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		
		// Click Action
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		
		// Close The Browser
//		driver.close();
		driver.quit();
	}
}