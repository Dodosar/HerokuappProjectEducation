package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
	
	private WebDriver driver;
	
	private By table = By.id("large-table");
	
	public LargeAndDeepDomPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void scrollToTable(){
	    WebElement tableElement = driver.findElement(table);
	    
	    String script = "arguments[0].scrollIntoView();";
	    ((JavascriptExecutor)driver).executeScript(script, tableElement);
	    
	   
	}
	
	public void domanainName() {
		String DomainName = ((JavascriptExecutor)driver).executeScript("return document.domain;").toString();
		System.out.println("Domain name of the site = "+ DomainName); 
	}
	
	public void scrollToButtom() {
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,4366)");
		 
		 ((JavascriptExecutor)driver).executeScript("window.scroll(0,0)");
	}
	
}
