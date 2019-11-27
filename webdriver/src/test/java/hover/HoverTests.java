package hover;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTests;


public class HoverTests extends BaseTests{
	
	@Test
	public void testHoverUser1() {
		
		var hoverPage = homePage.clickHovers();
		var caption = hoverPage.hoversOverFigure(1);
		
		assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
		assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
		assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
		assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
	}

}
