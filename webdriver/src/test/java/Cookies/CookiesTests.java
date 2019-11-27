package Cookies;

import static org.testng.Assert.*;

import org.openqa.selenium.Cookie;

import org.testng.annotations.Test;

import base.BaseTests;

public class CookiesTests extends BaseTests{
	
	@Test
    public void testDeleteCookie(){
        var cookieManager = homePage.clickCookiesCheck();
        Cookie cookie = cookieManager.buildCookie("Test", "%8B%TD");
        cookieManager.addCookie(cookie);
        cookieManager.deleteCookie(cookie);
        cookieManager.deleteCookies();
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }

}
