package com.automationintesting.actions;

import com.automationintesting.pages.LoginPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;

public class AuthActions {
    
    private final Page page;
    private final LoginPage loginPage;
    
    public AuthActions(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }
    
    public void loginAsAdmin(String username, String password) {
        
        page.waitForSelector("form", new WaitForSelectorOptions().setTimeout(120000));
        
        loginPage.clickAdminLink();
        
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
        
        page.waitForURL("**/#/admin"); 
    }
}