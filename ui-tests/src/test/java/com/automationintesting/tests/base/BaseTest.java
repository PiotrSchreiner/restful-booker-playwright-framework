package com.automationintesting.tests.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class BaseTest {

    protected static Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static final String BASE_URL = "http://localhost/"; 
    private static final int DOCKER_WAIT_SECONDS = 90; 

    @BeforeAll
    static void setupDocker() throws IOException, InterruptedException {
        System.out.println(">>> [Setup] Starte Docker Compose Services...");
        Process startProcess = Runtime.getRuntime().exec("docker compose up -d");
        startProcess.waitFor();
        System.out.println(">>> [Setup] Docker Compose gestartet.");
        
        Thread.sleep(DOCKER_WAIT_SECONDS * 1000L); 
        System.out.println(">>> [Setup] " + DOCKER_WAIT_SECONDS + " Sekunden Wartezeit abgeschlossen. Starte Tests...");
    }

    @AfterAll
    static void teardownDocker() throws IOException, InterruptedException {
        System.out.println(">>> [Teardown] Stoppe Docker Compose Services...");
        Process stopProcess = Runtime.getRuntime().exec("docker compose down");
        stopProcess.waitFor();
        System.out.println(">>> [Teardown] Docker Compose gestoppt.");
    }
    

    @BeforeEach
    void setupPlaywright() {
        if (playwright == null) {
            playwright = Playwright.create();
        }

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

        context = browser.newContext();
        page = context.newPage();
        
        page.setDefaultTimeout(120000); 
        
        page.navigate(BASE_URL);
    }

    @AfterEach
    void teardownPlaywright() {
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
    }
}