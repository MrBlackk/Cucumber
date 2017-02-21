package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;

/**
 * Created by chv on 21.02.2017.
 * Login page
 */
public class LoginPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passField;
    @FindBy(name = "commit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAsUser() {
        loginField.sendKeys(TestData.USER_LOGIN);
        passField.sendKeys(TestData.USER_PASS);
        submitButton.submit();
        return new HomePage(driver);
    }
}
