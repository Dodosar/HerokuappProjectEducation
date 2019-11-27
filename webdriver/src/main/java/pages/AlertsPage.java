package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
	
	private WebDriver driver;
	
	private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
	
	private By jsresult = By.id("result"); 
	
	private By triggerConfirmButton = By.xpath(".//button[.='Click for JS Confirm']");
	
	private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
	
	
	public AlertsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void triggerAlert() {
		driver.findElement(triggerAlertButton).click();
	}
	
	public void alert_clickToAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void alert_clickToDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public String alert_getText() {
		return driver.switchTo().alert().getText();
	}
	
	public String getJsResult() {
		return driver.findElement(jsresult).getText();
	}
	
	public void triggerConfirmAlert() {
		driver.findElement(triggerConfirmButton).click();
	}
	
	public void triggerPrompt(){
	    driver.findElement(triggerPromptButton).click();
	}
	
	public void alert_setInput(String text){
	    driver.switchTo().alert().sendKeys(text);
	}
	
}
