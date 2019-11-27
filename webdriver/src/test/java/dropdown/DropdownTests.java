package dropdown;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTests;
import pages.DropDownPage;

public class DropdownTests extends BaseTests{

	
	@Test
	public void testSelectOption() {
		DropDownPage dropDownPage = homePage.clickDropDown();
		
		String options = "Option 2";		
		dropDownPage.selectFromDropDown(options);
		List<String> selectedOptions = dropDownPage.getSelectedOptions();
		assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
		assertTrue(selectedOptions.contains(options), "Option not selected");
	}
}
