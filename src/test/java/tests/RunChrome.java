package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class RunChrome {
    @Test
    public void runBrowser() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://melodic-mind.com/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue with Email")).click();
        page.getByLabel("Email").click();
        page.getByLabel("Email").fill("y.shvydak@gmail.com");
        page.getByLabel("Password").click();
        page.getByLabel("Email").click();
        page.getByRole(AriaRole.MAIN).locator("div").filter(new Locator.FilterOptions().setHasText("Sign inSign upchevron_leftchevron_rightEmailPassworderrorPlease use a stronger p")).nth(1).click();
        page.getByLabel("Email").click(new Locator.ClickOptions()
                .setClickCount(3));
        page.getByLabel("Email").fill("y.shvydak+777@gmail.com");
        page.getByLabel("Password").click();
        page.getByLabel("Password").fill("qweQWE123!@#");
        page.getByText("Sign in", new Page.GetByTextOptions().setExact(true)).click();
        page.getByLabel("Password").first().click();
        page.getByLabel("Password").fill("qweQWE123!@#");
        page.getByLabel("Email").click();
        page.getByLabel("Email").fill("y.shvydak+777@gmail.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
        page.getByRole(AriaRole.TOOLBAR).getByRole(AriaRole.BUTTON).nth(1).click();
        page.getByLabel("close").click();
    }
}
