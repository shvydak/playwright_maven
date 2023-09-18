package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class RecordVideo {
    @Test
    public void recordVideo() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("output/")).setRecordVideoSize(1280, 720));

            Page page = context.newPage();
            page.navigate("https://demoqa.com/");
            page.click("'Elements'");
            page.click("'Alerts, Frame & Windows'");
            page.click("'Frames'");
            String res = page.frameLocator("#frame1").locator("#sampleHeading").textContent();

            // close
            context.close();
        }
    }
}
