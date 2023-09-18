package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class Iframes {
    @Test
    public void iframes() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://demoqa.com/");
        page.click("'Elements'");
        page.click("'Alerts, Frame & Windows'");
        page.click("'Frames'");
        String res = page.frameLocator("#frame1").locator("#sampleHeading").textContent();
        System.out.println(res);
    }
}
