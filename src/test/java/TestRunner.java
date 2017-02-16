import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by chv on 16.02.2017.
 * Test runner class that will use Cucumber
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report"},
        features = "src/test/resources"
)
public class TestRunner {
}
