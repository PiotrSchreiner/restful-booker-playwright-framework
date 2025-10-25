package com.automationintesting.tests;

import com.automationintesting.actions.AuthActions;
import com.automationintesting.actions.ContactActions; 
import com.automationintesting.tests.base.BaseTest;
import com.microsoft.playwright.Locator; 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    private AuthActions authActions;
    private ContactActions contactActions; 

    @Test
    public void UITS_T_001_successfulAdminLogin() {
        authActions = new AuthActions(page);

        authActions.loginAsAdmin("admin", "password");
        
        Assertions.assertTrue(page.url().endsWith("/#/admin"), 
            "Verifizierung fehlgeschlagen: Die URL sollte auf /#/admin enden nach erfolgreichem Login.");

        Locator logoutButton = page.locator("text=Logout");
        Assertions.assertTrue(logoutButton.isVisible(), 
            "Verifizierung fehlgeschlagen: Der Logout-Button ist nach dem Login nicht sichtbar.");
    }

    @Test
    public void UITS_T_002_successfulContactMessage() {
        contactActions = new ContactActions(page);
        
        contactActions.sendContactMessage(
            "Max Mustermann", 
            "max.mustermann@test.de", 
            "01234567890", 
            "Buchungsanfrage", 
            "Ich möchte ein Zimmer für nächste Woche buchen, bitte melden Sie sich."
        );
        
        Assertions.assertTrue(contactActions.isSuccessMessageVisible(),
            "Verifizierung fehlgeschlagen: Die Erfolgsmeldung nach dem Senden der Nachricht ist nicht sichtbar.");
    }
}