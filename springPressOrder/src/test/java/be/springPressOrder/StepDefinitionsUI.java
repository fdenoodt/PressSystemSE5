package be.springPressOrder;

import be.springPressOrder.PageObjects.MainPage;
import be.springPressOrder.PageObjects.PressOrderPage;
import be.springPressOrder.PageObjects.SignInPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.devtools.env.DevToolsHomePropertiesPostProcessor;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitionsUI {

    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    PressOrderPage pressOrderPage = new PressOrderPage(driver);


    @Given("^particulier is ingelogd$")
    public void particulierIsIngelogd() {
        mainPage.navigateToSignInPage();
        signInPage.signIn("username", "password");
    }


    @And("^de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken$")
    public void deParticulierBegeeftZichOpDePaginaOmEenNieuwePressorderAanTeMaken() {
        pressOrderPage = mainPage.navigateToPressOrderPage();
    }

    @When("^particulier (\\d+) peren invoert in het veld$")
    public void particulierPerenInvoertInHetVeld(int aantal) throws Throwable {
        pressOrderPage.voerPerenIn(aantal);
    }


    @And("^hij klikt op Submit$")
    public void hijKliktOpSubmit() {
        pressOrderPage.bevestigPersOrder();
    }


    @When("^de particulier (\\d+) appelen invoert in het veld$")
    public void deParticulierAppelenInvoertInHetVeld(int aantal) throws Throwable {
        pressOrderPage.voerAppelenIn(aantal);
    }

    @Then("^krijgt de particulier de volgende boodschap te zien : \"([^\"]*)\" in het veld$")
    public void krijgtDeParticulierDeVolgendeBoodschapTeZienInHetField(String msg) throws Throwable {
        String text = pressOrderPage.bekijkFoutMelding();
        assertThat(text).isEqualTo(msg);
    }


    @Then("^krijgt de particulier (\\d+) flessen$")
    public void krijgtDeParticulierFlessen(int aantal) {
        String text = pressOrderPage.bekijkResultaat();
        assertThat(text).contains(String.valueOf(aantal));
    }

    @And("^sluit de pagina$")
    public void sluitDePagina() {
        mainPage.closeDriver();
    }
}

