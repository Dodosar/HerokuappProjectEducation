package Wait;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import base.BaseTests;

public class FluentWait extends BaseTests{
	
	 	@Test
	    public void testWaitUntilHidden(){
	        var loadingPage = homePage.clickDynamicLoading().clickExample2();
	        
	        loadingPage.clickStart();
	        
	        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
	}

}
