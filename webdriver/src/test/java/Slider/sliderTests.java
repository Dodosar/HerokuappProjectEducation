package Slider;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTests;

public class sliderTests extends BaseTests{

	@Test
	public void setSliderNumberFour() {
		String value = "4";
		
		var slider = homePage.clickSliderPage();			

		slider.setSlider(value);
		
		assertNotNull(slider, "slider is exist");
		assertEquals(slider.getResult(), value, "result is incorrect");
		System.out.println(slider.getResult());
		
	}
	
}
