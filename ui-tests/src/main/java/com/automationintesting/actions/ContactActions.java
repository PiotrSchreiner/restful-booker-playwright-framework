package com.automationintesting.actions;

import com.automationintesting.pages.ContactPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Page.WaitForLoadStateOptions; 

public class ContactActions {
    
    private final ContactPage contactPage;
    private final Page page;
    
    public ContactActions(Page page) {
        this.page = page;
        this.contactPage = new ContactPage(page);
    }
    
    public void sendContactMessage(String name, String email, String phone, String subject, String message) {
        
        page.waitForSelector("form", new WaitForSelectorOptions().setTimeout(120000));
        
        page.waitForLoadState(
            com.microsoft.playwright.options.LoadState.NETWORKIDLE, 
            new WaitForLoadStateOptions().setTimeout(120000)
        );
        
        contactPage.fillName(name);
        contactPage.fillEmail(email);
        contactPage.fillPhone(phone);
        contactPage.fillSubject(subject);
        contactPage.fillMessage(message);
        
        contactPage.clickSubmit();
    }
    
    public boolean isSuccessMessageVisible() {
        return contactPage.getSuccessMessageLocator().isVisible();
    }
}