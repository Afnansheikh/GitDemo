package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {

	public WebDriver driver;
	By email = By.id("user_email");
	By sendMeInstruction = By.cssSelector("[type='submit']");

	
	public forgotPassword(WebDriver driver) {
		this.driver = driver;
	}

public WebElement getEmail() {
		
		return driver.findElement(email);
	}

public WebElement sendMeInstructions() {
	
	return driver.findElement(sendMeInstruction);
}
	

}
