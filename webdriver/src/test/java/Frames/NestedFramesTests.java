package Frames;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class NestedFramesTests extends BaseTests{
	
	@Test
	public void LeftFrameTest() {
		
		var nestedFr = homePage.clickNestedFrame();
		
		nestedFr.switchToTopFrame();

		//nestedFr.switchToLeftArea();
		
		//assertEquals(nestedFr.getText(), "LEFT", "incorrect value");
		
		//nestedFr.exitToMaifFrame();
		
	}
	
	@Test
	public void BottomFrameTest() {
		
		 var nestedFr = homePage.clickNestedFrame();
		 
		 nestedFr.switchToBottomFrame();
		 
		 assertEquals(nestedFr.getText(), "BOTTOM", "incorrect value");
		 
		 nestedFr.exitToMaifFrame();
	}

}
