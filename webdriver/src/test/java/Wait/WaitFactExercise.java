package Wait;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import base.BaseTests;

public class WaitFactExercise extends BaseTests{
	
	@Test
	public void FactTest() {
		var factExercise = homePage.clickDynamicLoading().clickExampleFact();
		
		factExercise.clickStart();
		
		assertEquals(factExercise.getText(), "Hello World!", "incorrect Text");
	}
}
