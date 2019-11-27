package Frames;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class FramesTests extends BaseTests{

	@Test
	public void ParagraphTest() {
		var editorPage = homePage.clickFramesPage();
		editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);
	
		assertEquals(editorPage.getTextFromEditor(),text1 + text2 ,"Text from editor is incorrect");
	}
}
