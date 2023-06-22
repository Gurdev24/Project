package testlayer;

import java.time.Duration;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRclass;
import pompackage.Pomlogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRclass
{
	Pomlogin log;

	public LoginTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void initsetup()
	{
		initiation();
		//screenshots("login");
		log = new Pomlogin();
		
	}
	
	
	@Test(priority=1)
	public void Title() {
		String actual = log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details()
	{
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=2, dataProvider="Details")
	
	public void Login(String name, String password)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//log.typeusername(prop.getProperty("username"));
		//log.typepassword(prop.getProperty("password"));
		log.typeusername(name);
		log.typepassword(password);
		//log.clickb();		
	}
	
	@AfterMethod
	public void close()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.close();
	}
	
}
