package be.springPressOrder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertTrue;

public class StepDefinitions {

    @Given("^I am signed in as a klant$")
    public void iAmSignedInAsAKlant() throws Throwable {

    }

    @And("^I am on the page where I can add a new house$")
    public void iAmOnThePageWhereICanAddANewHouse() throws Exception {
        throw new Exception("kl;fsda");
    }
}
