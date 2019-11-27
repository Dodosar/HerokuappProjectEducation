package ModalWindow;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;

public class ModalTests extends BaseTests{
		
	@Test
	public void closeTestModal() throws InterruptedException {
		var modal = homePage.clickEntryAd();
		
		modal.clickHere();
		
		assertTrue(modal.isDisplay());
		
		assertEquals(modal.getTextOnModal(),
				"It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker)." ,
				"Incorrect text");
		
		modal.closeModal();
		
		assertEquals(modal.getTextEntryPage(), "Entry Ad","Incorrect Page");
	}	
}
