package be.springPressOrder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class StepDefinitionsUI {


    WebDriver driver;


    @Given("^particulier is ingelogd$")
    public void particulierIsIngelogd() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fabian\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/login");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.id("btnSubmit")).click();
    }

    @And("^de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken$")
    public void deParticulierBegeeftZichOpDePaginaOmEenNieuwePressorderAanTeMaken() {
        driver.navigate().to("http://localhost:8080/pressorder/new");
    }

    @When("^particulier (\\d+) peren invoert in het veld \"([^\"]*)\"$")
    public void particulierPerenInvoertInHetVeld(int aantal, String id) throws Throwable {
        driver.findElement(By.id(id)).sendKeys(String.valueOf( aantal));
    }

    @And("^hij duidt peer aan in de combobox \"([^\"]*)\"$")
    public void hijDuidtPeerAanInDeCombobox(String id) throws Throwable {
        Select select=new Select(driver.findElement(By.id(id)));
        select.selectByValue("2");
    }

    @And("^hij klikt op Submit$")
    public void hijKliktOpSubmit() {
        driver.findElement(By.id("btnSubmit")).click();
    }

    @Then("^krijgt de particulier de volgende boodschap op het scherm te zien: \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeBoodschapOpHetSchermTeZien(String arg0) throws Throwable {
        
    }

}
