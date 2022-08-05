package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	private  By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("(//div[@class='text-center'])[1]");
	private By navbar = By.cssSelector(".navbar-collapse.collapse");
	private By header = By.cssSelector("div[class*='video-banner']");

	public landingPage(WebDriver driver) {
		this.driver = driver;
	}

	public loginPage getLogin() {

		driver.findElement(signin).click();
		return new loginPage(driver);
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}
	
	public WebElement getNavbar() {

		return driver.findElement(navbar);
	}
	
	public WebElement getheader() {

		return driver.findElement(header);
	}


}
