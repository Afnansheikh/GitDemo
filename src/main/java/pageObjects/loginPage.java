package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.name("commit");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
    public WebElement getPassword() {
		
		return driver.findElement(password);
	}
    
    public WebElement getLogin() {
		
		return driver.findElement(login);
	}
    
    public forgotPassword getForgotPassword() {
		
		driver.findElement(forgotPassword).click();
		return new forgotPassword(driver);
	}
	
	

}
