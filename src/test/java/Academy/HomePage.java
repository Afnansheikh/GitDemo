package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.forgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String email,String password,String text) {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
		landingPage l = new landingPage(driver);
		loginPage lp = l.getLogin();
		lp.getEmail().sendKeys(email); 
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		log.info(text);
		forgotPassword fp = lp.getForgotPassword();
		fp.getEmail().sendKeys("abcd");
		fp.sendMeInstructions().click();
		}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "restricted user";
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "3456";
		data[1][2] = "non restricted user";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	

	}


