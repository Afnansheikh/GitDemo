package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class base {

	public static WebDriver driver;
	public Properties prop;

	@SuppressWarnings("deprecation")
	public  WebDriver initializeDriver() throws IOException {
//		Data driven
		prop =new Properties();	
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
	prop.load(fis);
	String browserName=System.getProperty("browser");
	System.out.println(browserName);
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
		ChromeOptions options = new ChromeOptions();
		if(browserName.contains("headless"))
		{
		
		options.addArguments("headless");
		
		}
		driver = new ChromeDriver(options);
	}
	else if(browserName.equals("firefox"))
	{
		//code for opening in Fire fox
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}

	public String getScreenshotPath(String testMethodName,WebDriver driver) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"//reports//"+testMethodName+".png";
	FileUtils.copyFile(src,new File(destinationFile));
	return destinationFile;

	}
	
	
	
  
}