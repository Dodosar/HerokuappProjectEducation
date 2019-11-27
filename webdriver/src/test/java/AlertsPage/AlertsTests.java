package AlertsPage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class AlertsTests extends BaseTests{
	
	@Test
	public void JSAlertTest() {
		var jsAlert = homePage.clickAlertsPage();
		
		jsAlert.triggerAlert();
		
		jsAlert.alert_clickToAccept();
		
		assertEquals(jsAlert.getJsResult(), "You successfuly clicked an alert");		
	}
	
	@Test 
	public void JSConfirmAlert() {
		var jsAlerts = homePage.clickAlertsPage();
		
		jsAlerts.triggerConfirmAlert();
		
		String text = jsAlerts.alert_getText();
		
		jsAlerts.alert_clickToAccept();
		
		assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
	}
	
	@Test
	public void testSetInputInAlert(){

	    var alertsPage = homePage.clickAlertsPage();
	    alertsPage.triggerPrompt();

	    String text = "TAU rocks!";
	    alertsPage.alert_setInput(text);
	    alertsPage.alert_clickToAccept();

	    assertEquals(alertsPage.getJsResult(),"You entered: " + text, "Results text incorrect");
	}
}
