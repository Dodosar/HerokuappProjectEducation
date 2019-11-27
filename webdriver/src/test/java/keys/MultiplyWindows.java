package keys;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;


public class MultiplyWindows extends BaseTests{
	
	@Test
	public void FactExampleTests() {
		var buttonPage = homePage.clickDynamicLoading().clickExample2Page();
		getWindowManager().switchToTab();
		assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
	}
}
