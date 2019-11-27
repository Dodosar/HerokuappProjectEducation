package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFrames {
	
	private WebDriver driver;
	
	private String LeftFrame = "frame-left";
	
	private By text = By.tagName("body");
	
	private String BottomFrame = "frame-bottom";
	
	@SuppressWarnings("unused")
	private String topFrame = "frame-top";
	
	
	public NestedFrames(WebDriver driver) {
		this.driver= driver;
	}
	
	public void switchToTopFrame() {
		driver.switchTo().frame("topFrame");	
	}
	
	public void switchToLeftArea() {
		driver.switchTo().frame("topFrame");	
		driver.switchTo().frame(LeftFrame);
	}

	public void exitToMaifFrame() {
		driver.switchTo().parentFrame(); //exit left to top
        driver.switchTo().parentFrame(); //exit top to main
	}
	
	public String getText() {
		return driver.findElement(text).getText();
	}
	
	public void switchToBottomFrame() {
		driver.switchTo().frame(BottomFrame);
	}	

}
