package forgotPassword;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTests;

public class forgotPasswordTests extends BaseTests{
	
	@Test
	public void testSendingEmail() {
		var forgotPasswordTests = homePage.clickForgotPass();
		forgotPasswordTests.enterEmail("tau@example.com");
		forgotPasswordTests.clickSubmitButton();
		
		assertTrue(forgotPasswordTests.isDisplayText(), "Text is not visible in the page");
		assertEquals(forgotPasswordTests.checkEmail(), "Your e-mail's been sent!", "Email was not sent!");
		
	}
}
