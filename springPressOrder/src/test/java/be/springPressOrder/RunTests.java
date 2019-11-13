package be.springPressOrder;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "html:target/cucumber"},
        features = {"classpath:be.springPressOrder"},
        tags = {"~@skip"})
public class RunTests {
}

