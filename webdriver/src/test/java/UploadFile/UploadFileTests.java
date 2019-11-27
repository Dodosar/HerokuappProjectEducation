package UploadFile;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import base.BaseTests;

public class UploadFileTests extends BaseTests{
	

	@Test(alwaysRun = true)
    public void testFileUpload(){
        var uploadPage = homePage.clickUploadPage();
        uploadPage.uploadFile("C:\\Users\\tyudm\\eclipse-workspace\\webdriver\\pom.xml");
        
        assertEquals(uploadPage.getUploadedFiles(), "pom.xml", "Uploaded files incorrect");
    }
}
