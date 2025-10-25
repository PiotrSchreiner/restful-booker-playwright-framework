package com.automationintesting.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.FillOptions;

public class LoginPage {
    
    private final Page page;
    
    private final Locator adminLink;
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;
    
    public LoginPage(Page page) {
        this.page = page;
        this.adminLink = page.locator("#navAdmin");
        this.usernameField = page.locator("input[name='username']"); 
        this.passwordField = page.locator("input[name='password']"); 
        this.loginButton = page.locator("#doLogin"); 
    }
    
    public void clickAdminLink() {
        adminLink.click(new ClickOptions().setForce(true));
    }
    
    public void fillUsername(String username) {
        usernameField.fill(username, new FillOptions().setForce(true));
    }
    
    public void fillPassword(String password) {
        passwordField.fill(password, new FillOptions().setForce(true));
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }
}