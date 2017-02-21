package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 21.02.2017.
 * Home page
 */
public class HomePage extends BasePage {
    @FindBy(className = "header")
    private WebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkForNavigation() {
        return header.isDisplayed();
    }
}
