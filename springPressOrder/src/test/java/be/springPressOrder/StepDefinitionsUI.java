package be.springPressOrder;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class StepDefinitionsUI {


    File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    FirefoxProfile firefoxProfile = new FirefoxProfile();

    WebDriver driver; // = new FirefoxDriver(ffBinary,firefoxProfile);


    @Given("^particulier is ingelogd$")
    public void particulierIsIngelogd() {
        // driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "D:\\onedrive\\OneDrive - ODISEE\\Fabian\\Jaar 2\\Semester 2\\Software\\w6\\geckodriver.exe");
        driver = new FirefoxDriver(ffBinary, firefoxProfile);

//        driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/");
//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).sendKeys("password");
//
//        driver.findElement(By.id("btnSubmit")).click();
    }

    @And("^de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken$")
    public void deParticulierBegeeftZichOpDePaginaOmEenNieuwePressorderAanTeMaken() {
    }

    @When("^particulier (\\d+) peren invoert in het veld \"([^\"]*)\"$")
    public void particulierPerenInvoertInHetVeld(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^hij duidt peer aan in de combobox \"([^\"]*)\"$")
    public void hijDuidtPeerAanInDeCombobox(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^hij klikt op Submit$")
    public void hijKliktOpSubmit() {

    }

    @Then("^krijgt de particulier de volgende boodschap op het scherm te zien: \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeBoodschapOpHetSchermTeZien(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

}
