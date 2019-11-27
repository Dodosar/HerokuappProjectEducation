package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
	
	private WebDriver driver;
	
	private By slider = By.xpath("//input[@type='range']");
	
	private By result = By.id("range");
	
	public HorizontalSliderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setSlider(String value) {
		while(!getResult().equals(value)) {
		driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
	}
	}
	
	public String getResult() {
		return driver.findElement(result).getText();
	}
	


}
