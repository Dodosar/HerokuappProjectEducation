package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	private WebDriver driver;
	
	private By dropdown = By.id("dropdown");
	
	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectFromDropDown(String option) {
		
		findDropDownElement().selectByVisibleText(option);
	}
	
	public List<String> getSelectedOptions() {
		List<WebElement> selectedElemnents = 
				findDropDownElement().getAllSelectedOptions();
		return selectedElemnents.stream().map(e->e.getText()).collect(Collectors.toList());
	}
	
	private Select findDropDownElement() {
		return new Select(driver.findElement(dropdown));
	}
	
	 public void addMultipleAttribute(){
		 
		 String script = "arguments[0].setAttribute('multiple','')";
	     ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
	 }
}
