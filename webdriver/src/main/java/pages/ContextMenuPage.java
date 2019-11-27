package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
	
	private WebDriver driver;
	
	private By box = By.id("hot-spot");
	
	private By namePage = By.xpath(".//h3[.='Context Menu']");
	
	public ContextMenuPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void rightClick() {		
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(box)).perform();		
	}
	
	public String textInPopUp() {
		return driver.switchTo().alert().getText();
	}
	
	public void popup_acceptClick() {
		driver.switchTo().alert().accept();
	}
	
	public String getTextManePage() {
		return driver.findElement(namePage).getText();
	}
}
