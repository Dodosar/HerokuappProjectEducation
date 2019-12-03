package base;


import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    public static Logger log = Logger.getLogger("devpinoyLogger");
	public static String screenshotName;
    private String nodeURL = "http://192.168.1.104:4444/wd/hub";
    
	@SuppressWarnings("deprecation")
	@Parameters("browserType")
	@BeforeClass(alwaysRun = true)
    public void setUp(String browserType){
		if(browserType.equalsIgnoreCase("Chrome")) {
    	System.setProperty("webdriver.chrome.driver", 
    			System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
    	/*ChromeDriverManager.edgedriver().setup();*/
    	
    	
		driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
		log.debug("Chrome Opened!!!");
		}
		else if(browserType.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", 
	    			System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new EventFiringWebDriver(new FirefoxDriver(getFireFoxOption()));

		driver.manage().window().maximize();
		
		}
		else if (browserType.equals("ChromeRemote")) {
				
		try {
			driver = new EventFiringWebDriver( new RemoteWebDriver(new URL(nodeURL), getRemoteChromeOptions()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		driver.register(new EventReporter());
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

		goHome();
		setCookie();   
    }
	
	private Capabilities getFireFoxOption() {
		
		FirefoxOptions options = new FirefoxOptions();	
    	options.setHeadless(true);//What this means is it'll run our tests without actually opening our browser up.		
    	return options;
	}

	private void setCookie(){
	    Cookie cookie = new Cookie.Builder("dimaCoockie", "123").
	    		domain("the-internet.herokuapp.com")
	    				.build();
	    driver.manage().addCookie(cookie);
	}
	
	
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();    	
    	options.addArguments("test-type");
    	options.addArguments("start-maximized");
    	options.addArguments("disable-infobars");
    	options.addArguments("--disable-notifications");
    	options.addArguments("--disable-extenstions"); 
    	options.setHeadless(true); //What this means is it'll run our tests without actually opening our browser up.
    	return options;
	}
	
	public ChromeOptions getRemoteChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
    	 options.addArguments("start-maximized");
    	 options.addArguments("disable-infobars");
        //options.addArguments("--proxy-pac-url=http://myPacFile.com");
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.addArguments("--no-sandbox");
  	  	options.setCapability("javascriptEnabled", "true");
    	options.setHeadless(true); //What this means is it'll run our tests without actually opening our browser up.
    	return options;
	}
	
	public WindowManager getWindowManager(){
	    return new WindowManager(driver);
	}
    

	@AfterClass(alwaysRun = true)
    public void tearDown() {
    	if(driver != null) {
    		driver.quit();
    	}    	
    }
	
	//@BeforeTest : It will call Only once, before Test method.
	@BeforeMethod //@BeforeMethod It will call Every time before Test Method.
	public void goHome() {
		driver.get("https://the-internet.herokuapp.com/");
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void takeScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "test\\resources\\screenshots\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot taken: " + scrFile.getAbsolutePath());
	}
	
	
	/*@AfterMethod
public void takeScreenshot(){

    var camera = (TakesScreenshot)driver;
    File screenshot = camera.getScreenshotAs(OutputType.FILE);

    try{
        Files.move(screenshot, new File("resources/screenshots/test.png"));
    }catch(IOException e){
        e.printStackTrace();
    }
}*/
	 
	
	@AfterMethod
	public void recordFailure(ITestResult result){
		
	    if(ITestResult.FAILURE == result.getStatus())
	    {
	        var camera = (TakesScreenshot)driver;
	        File screenshot = camera.getScreenshotAs(OutputType.FILE);
	        try {
				Files.move(screenshot, new File(System.getProperty("user.dir") + "test\\resources\\screenshots\\" 
	        + result.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	}
   }