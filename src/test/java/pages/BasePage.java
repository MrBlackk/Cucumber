package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chv on 21.02.2017.
 * Base page
 */
public abstract class BasePage {
    private static final String LOGIN_URL = "https://github.com/login";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToSignInPage() {
        driver.navigate().to(LOGIN_URL);
        return new LoginPage(driver);
    }
}
