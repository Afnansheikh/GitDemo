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

public class ValidateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	landingPage l;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
	}

	@Test
	public void basePageTitle()  {

		l = new landingPage(driver);

		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
		

	}
	
	@Test
	public void basePageHeader()  {


		AssertJUnit.assertEquals(l.getheader().getText(), "An Academy to learn Everything about Testing");
		log.info("Successfully validated header text message");
		

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
