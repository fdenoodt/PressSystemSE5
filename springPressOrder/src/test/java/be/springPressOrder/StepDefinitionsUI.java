package be.springPressOrder;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;


public class StepDefinitionsUI {


    WebDriver driver;


    @Given("^particulier is ingelogd$")
    public void particulierIsIngelogd() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\steve\\Downloads\\chromedriver.exe");
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


    @When("^de particulier (\\d+) appelen invoert in het veld \"([^\"]*)\"$")
    public void deParticulierAppelenInvoertInHetVeld(int aantal, String id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id(id)).sendKeys(String.valueOf( aantal));
    }

    @And("^hij duidt appel aan in de combobox \"([^\"]*)\"$")
    public void hijDuidtAppelAanInDeCombobox(String id) throws Throwable {
        Select select=new Select(driver.findElement(By.id(id)));
        select.selectByValue("1");
    }

    @Then("^krijgt de particulier de volgende boodschap te zien : \"([^\"]*)\" in het field \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeBoodschapTeZienInHetField(String msg, String field) throws Throwable {
        assertThat(driver.findElement(By.id(field)).getText()).isEqualTo(msg);
    }


    @Then("^krijgt de particulier (\\d+) flessen$")
    public void krijgtDeParticulierFlessen(int aantal) {
        assertThat(driver.findElement(By.id("resultaat")).getText()).isEqualTo(aantal);
    }

}

