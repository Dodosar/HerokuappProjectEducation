package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EntryAdPage {	
	
	private WebDriver driver;	
	
	//private WebDriverWait wait = new WebDriverWait(driver,5);
	
	private By closeButton = By.xpath(".//p[text()='Close']");
	
	private By triggerModale = By.id("restart-ad");
	
	private By modalWindow = By.className("modal");
	
	private By getText = By.xpath(".//div[@class='modal-body']/p");
	
	private By confirmEntryPage = By.xpath(".//h3[text()='Entry Ad']");
	
	public EntryAdPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickTrigger() {
		driver.findElement(triggerModale).click();		
	}
	
	public String getWindowHandle() {
		String madalWindow = driver.getWindowHandle();
		return madalWindow;
	}
	
	public void closeModal() {		
		driver.switchTo().window(getWindowHandle()).findElement(closeButton).click();
	}
	
	public boolean isDisplay() throws InterruptedException {
		driver.switchTo().window(getWindowHandle());		
		Thread.sleep(2000);	
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		 
		return driver.findElement(modalWindow).isDisplayed();
	}
	
	public String getTextOnModal() {
		return driver.findElement(getText).getText();
	}
	
	public String getTextEntryPage() {
		return driver.findElement(confirmEntryPage).getText();
	}
	
	
	public void clickHere(){
        driver.findElement(triggerModale).click();
    }
}
