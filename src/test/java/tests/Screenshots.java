package tests;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.Arrays;

public class Screenshots {
    @Test
    public void screenShots() {
        try (Playwright playwright = Playwright.create()) {

            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

            page.navigate("https://demoqa.com/");
            page.click("'Elements'");
            page.click("'Alerts, Frame & Windows'");
            page.click("'Frames'");
            String res = page.frameLocator("#frame1").locator("#sampleHeading").textContent();

            //  Viewed Page
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("output/lastScreenshot.png")));

            //  Full Page
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("output/lastScreenshotFullPage.png")).setFullPage(true));

            // Element
            Locator alerts = page.getByText("Alerts, Frame & Windows");
            alerts.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("output/alerts.png")));

            Assert.assertEquals(res, "This is a sample page");
        }
    }
}
