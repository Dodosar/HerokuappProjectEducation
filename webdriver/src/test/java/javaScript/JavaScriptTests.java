package javaScript;

import base.BaseTests;

import static org.testng.Assert.*;

import java.util.List;

import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDomPage().scrollToTable();
    }
    
    @Test
    public void testDomain(){
        homePage.clickLargeAndDeepDomPage().domanainName();
    }
    
    @Test
    public void testScrollToButtom(){
        homePage.clickLargeAndDeepDomPage().scrollToButtom();
    }
    
    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
    
    @Test
    public void testSelectOption() {
    	var dropDownPage = homePage.clickDropDown();
    	
    	dropDownPage.addMultipleAttribute();
    	
    	var optionsToSelect = List.of("Option 1", "Option 2");
    	optionsToSelect.forEach(dropDownPage::selectFromDropDown);
        optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
    
}