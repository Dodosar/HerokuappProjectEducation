package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicExample2Page {
	
	private WebDriver driver;
	
	private By startButton = By.cssSelector("#start button");
	
	private By finish = By.id("finish");

	public DynamicExample2Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void clickStart() {
		driver.findElement(startButton).click();
		WebDriverWait wait = new WebDriverWait(driver,7);		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(finish)));
	}
	
	public String getText() {
		return driver.findElement(finish).getText();
	}

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }

}
