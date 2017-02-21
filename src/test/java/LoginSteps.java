import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

/**
 * Created by chv on 16.02.2017.
 * Login Steps
 */
public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;

    static {
        try {
            System.setProperty("webdriver.chrome.driver", LoginSteps.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath());
        } catch (Exception ex) {
            System.out.println("Cannot launch Chrome driver \n" + ex.getMessage());
        }
    }

    @Given("^the Github Login page$")
    public void the_Github_Login_page() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.navigateToSignInPage();
    }

    @When("^logging in as an user$")
    public void logging_in_as_an_user() throws Throwable {
        homePage = loginPage.loginAsUser();
    }

    @Then("^the home page navigation is available$")
    public void the_home_page_navigation_is_available() throws Throwable {
        assertTrue("Navigation is absent", homePage.checkForNavigation());
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
