package login;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests{	
	
	@Test(dataProvider = "logInData")
	public void testSuccessfulLogin(String name, String password) {
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername(name);
		System.out.println("UserName: " + name );
		loginPage.setPassword(password);
		System.out.println("Password: " + password );
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect!");
	}
	
	@DataProvider
	public Object [] [] logInData(){
		Object [][] data = new Object [2][2];
		
		data [0][0] = "tomsmith" ; data [0][1] = "SuperSecretPassword!";
		
		data [1][0] = "Pe" ; data [1][1] = "SuperSecretPassword!";
		return data;
	}
	
	@Test(dataProviderClass = DPclass.class, dataProvider = "log-in-data")
	public void testSuccessfulLogin2(String name, String password) {
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername(name);
		System.out.println("UserName: " + name );
		loginPage.setPassword(password);
		System.out.println("Password: " + password );
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect!");
	}
	
	@Parameters({"user", "password"})
	@Test
	public void testSuccessfulLogin3Parameters(String user, String password) {
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername(user);
		System.out.println("UserName: " + user );
		loginPage.setPassword(password);
		System.out.println("Password: " + password );
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect!");
	}
}
