package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class Locators {
    @Test
    public void locators() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://melodic-mind.com/");
        page.click("'Login '");
        page.click("' Continue with Email '");

    }
}
