package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Trace {
    @Test
    public void trace() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            // start
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

            Page page = context.newPage();
            page.navigate("https://demoqa.com/");
            page.click("'Elements'");
            page.click("'Alerts, Frame & Windows'");
            page.click("'Frames'");
            String res = page.frameLocator("#frame1").locator("#sampleHeading").textContent();
            // stop
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("output/Trace.zip")));
            System.out.println(res);
        }
    }
}
