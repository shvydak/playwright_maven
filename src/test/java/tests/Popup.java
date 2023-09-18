package tests;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.Test;

public class Popup {
    @Test
    public void popUp() {
        // Instruments loaded!

        try (Playwright playwright = Playwright.create()) {
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

            page.navigate("https://la-vocal.melodic-mind.com/");
            page.getByText("Do vocal exercises").click();


            Locator popup = page.locator("'Instruments loaded!'");
            page.waitForSelector("'Instruments loaded!'", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
            page.waitForSelector("'Instruments loaded!'", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(10000));


        }
    }
}