package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;

import com.crm.BaseClass.VtigerBase;
import com.crm.fileUtility.ReadFromExcelFile;
import com.crm.javaUtility.GenerateRandomNumbers;
import com.crm.pom.HomePage;
import com.crm.pom.Organization;

public class OrganizationTestCase extends VtigerBase
{
	public void testCase() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		
		assertTrue(hp.home().isDisplayed(), "I Am Not In Vtiger HomePage");
		
		Reporter.log("I AM In Vtiger Home Page");
		
		hp.organization();
		
		Organization org = new Organization(driver);
		
		org.plusorg();
		
		String orgname = ReadFromExcelFile.readExcel("Organization", 0, 0);
		
		int dynamicNumber = GenerateRandomNumbers.random();
		
		String expected_org = orgname+dynamicNumber;
		
		org.accountName(orgname+dynamicNumber);
		
		org.save();
		
		String actual_org = org.header().getText();
		
		assertTrue(actual_org.contains(expected_org));
		
		Thread.sleep(2000);
	}
}