import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chv on 16.02.2017.
 * Login Steps
 */
public class LoginSteps {

    WebDriver driver;

    static {
        try {
            System.setProperty("webdriver.chrome.driver", LoginSteps.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath());
        } catch (Exception ex) {
            System.out.println("Cannot launch Chrome driver \n" + ex.getMessage());
        }
    }

    @Given("^the Github Sign In page$")
    public void the_Github_Sign_In_page() throws Throwable {
        driver.get("https://github.com/login");
    }

    @When("^logging in as an user$")
    public void logging_in_as_an_user() throws Throwable {
        driver.findElement(By.id("login_field")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.name("commit")).submit();
    }

    @Then("^the home page navigation is available$")
    public void the_home_page_navigation_is_available() throws Throwable {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("header")));
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
