package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;


	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public LoginPage clickFormAuthentication() {
		clickLink("Form Authentication");
	     return new LoginPage(driver);
	}
	
	public DropDownPage clickDropDown() {
		clickLink("Dropdown");
		return new DropDownPage(driver);
	}
	
	public HoversPage clickHovers() {
		clickLink("Hovers");
		return new HoversPage(driver);
	}
	
	public KeyPressPage clickKeyPress() {
		clickLink("Key Presses");
		return new KeyPressPage(driver);
	}
	
	public ForgotPasswordPage clickForgotPass() {
		clickLink("Forgot Password");
		return new ForgotPasswordPage(driver);
	}
	
	public HorizontalSliderPage clickSliderPage() {
		clickLink("Horizontal Slider");
		return new HorizontalSliderPage(driver);
	}
	
	public AlertsPage clickAlertsPage() {
		clickLink("JavaScript Alerts");
		return new AlertsPage(driver);
	}
	
	public FileUploadPage clickUploadPage() {
		clickLink("File Upload");
		return new FileUploadPage(driver);
	}
	
	public EntryAdPage clickEntryAd() {
		clickLink("Entry Ad");
		return new EntryAdPage(driver);
	}
	
	public ContextMenuPage clickContextPage() {
		clickLink("Context Menu");
		return new ContextMenuPage(driver);
	}
	
	public Frames clickFramesPage() {
		clickLink("WYSIWYG Editor");
		return new Frames(driver);
	}
	
	public NestedFrames clickNestedFrame() {
		clickLink("Frames");
		clickLink("Nested Frames");
		return new NestedFrames(driver);
	}
	
	
	public DynamicLoadingPage clickDynamicLoading(){
	    clickLink("Dynamic Loading");
	    return new DynamicLoadingPage(driver);
	}
	
	public LargeAndDeepDomPage clickLargeAndDeepDomPage() {
		clickLink("Large & Deep DOM");
		return new  LargeAndDeepDomPage(driver);
	}
	
	public InfiniteScrollPage clickInfiniteScroll(){
	    clickLink("Infinite Scroll");
	    return new InfiniteScrollPage(driver);
	}
	
	public Cookies clickCookiesCheck(){
		return new Cookies(driver);		
	}
	
	public MultipleWindowsPage clickMultipleWindows(){
	    clickLink("Multiple Windows");
	    return new MultipleWindowsPage(driver);
	}
	
	private void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}


}
