package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigationTests extends BaseTests {
	
	SoftAssert softassert = new SoftAssert();
	

	
    @Test( groups = { "checkintest","broken" } ,description = "Test")
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");       
        
        
        softassert.assertEquals(true, false, "The Welcome Link Is Not Correct On The Home Page");
        System.out.println("3. Verify Welcome Link");
        
        softassert.assertFalse(false, "The Admin Tab Is Not Displayed On The Home Page");
        System.out.println("4. Verify Admin Tab");
        
        softassert.assertTrue(false, "The Dashboard Is Not Correct On The Home Page");
        System.out.println("5. Verify Dashboard");	
        
        softassert.assertAll();
    }
    
    @Test(groups = {"functest", "checkintest"} )
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}