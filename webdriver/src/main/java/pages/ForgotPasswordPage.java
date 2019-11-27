package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	
	private By emailField = By.id("email");
	
	private By submitButton = By.id("form_submit");
	
	private By contentEmail = By.id("content");
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public String checkEmail() {
		return driver.findElement(contentEmail).getText();
	}
	
	public boolean isDisplayText() {
		return driver.findElement(contentEmail).isDisplayed();
	}
	
}
