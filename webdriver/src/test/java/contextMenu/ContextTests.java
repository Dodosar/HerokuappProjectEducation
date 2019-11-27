package contextMenu;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class ContextTests extends BaseTests{
	
	@Test
	public void testRightClick() {
		var context = homePage.clickContextPage();
		
		context.rightClick();
		
		assertEquals(context.textInPopUp(), "You selected a context menu");
		
		context.popup_acceptClick();
		
		assertEquals(context.getTextManePage(), "Context Menu");
	}
}
