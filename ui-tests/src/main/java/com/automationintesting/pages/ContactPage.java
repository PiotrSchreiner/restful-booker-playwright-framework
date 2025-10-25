package com.automationintesting.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.ClickOptions;

public class ContactPage {
    
    // DEKLARATION: Alle Variablen MÜSSEN hier als Felder der Klasse deklariert werden.
    private final Page page;
    private final Locator nameField;
    private final Locator emailField;
    private final Locator phoneField;
    private final Locator subjectField;
    private final Locator messageField;
    private final Locator submitButton;
    private final Locator successMessage;

    // INITIALISIERUNG: Die Zuweisung erfolgt im Konstruktor.
    public ContactPage(Page page) {
        this.page = page;
        this.nameField = page.locator("#name");
        this.emailField = page.locator("#email");
        this.phoneField = page.locator("#phone");
        this.subjectField = page.locator("#subject");
        this.messageField = page.locator("#description");
        this.submitButton = page.locator("#submitContact");
        this.successMessage = page.locator("div.alert"); 
    }
    
    // Methoden bleiben unverändert
    public void fillName(String name) {
        nameField.fill(name);
    }
    
    public void fillEmail(String email) {
        emailField.fill(email);
    }
    
    public void fillPhone(String phone) {
        phoneField.fill(phone);
    }
    
    public void fillSubject(String subject) {
        subjectField.fill(subject);
    }
    
    public void fillMessage(String message) {
        messageField.fill(message);
    }
    
    public void clickSubmit() {
        submitButton.click(new ClickOptions().setForce(true));
    }
    
    public Locator getSuccessMessageLocator() {
        return successMessage;
    }
}