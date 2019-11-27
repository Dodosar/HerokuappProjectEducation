package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frames {
	
	private WebDriver driver;
	
	//private String editorIframeId = "mce_0_ifr";
	
	private By textArea = By.id("tinymce");
	
	private By decreaseIndentButton = By.cssSelector("#mceu_12 button");
	
	public Frames(WebDriver driver) {
		this.driver=driver;
	}

	private void switchToEditArea() {
		driver.switchTo().frame(0);
	}
	
	public void clearTextArea() {
		switchToEditArea();
		driver.findElement(textArea).clear();
		switchToMainArea();
	}
	
	private void switchToMainArea(){
	    driver.switchTo().parentFrame();
	}
	
	public void setTextArea(String text) {
		switchToEditArea();
		driver.findElement(textArea).sendKeys(text);
		switchToMainArea();
	}
	
	public void decreaseIndention() {
		driver.findElement(decreaseIndentButton).click();
	}
	
	public String getTextFromEditor(){
	    switchToEditArea();
	    String text = driver.findElement(textArea).getText();
	    switchToMainArea();
	    return text;
	}
	
}
