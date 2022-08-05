package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;


import pageObjects.landingPage;
import resources.base;

public class ValidateNavbar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() {
		

		landingPage l = new landingPage(driver);

		AssertJUnit.assertTrue(l.getNavbar().isDisplayed());
		log.info("Navigated bar is displayed");
		

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
