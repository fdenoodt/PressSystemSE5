package be.springPressOrder.resources;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.persistence.Convert;


public class MyStepdefs {

    WebDriver driver;

    @Given("^I am on the page where I can add one Order$")
    public void i_am_on_the_page_where_I_can_add_a_new_order() throws Throwable{
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new ChromeDriver();

        //driver = new ChromeDriver();
        //inloggen
        driver.navigate().to("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("signin")).submit();
        //ga naar de form om een order toe te voegen
        driver.navigate().to("http://localhost:8080/order/new");
    }


    @When("^I enter (\\d+) in the amount field$")
    public void iEnterInTheAmountField(int arg0) {
        driver.findElement(By.id("amount")).sendKeys(Integer.toString(arg0));
    }

    @And("^I enter \"([^\"]*)\" in the juice field$")
    public void iEnterInTheJuiceField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("username")).sendKeys("admin");
    }

    @And("^I enter (\\d+) in the client id field$")
    public void iEnterInTheClientIdField(int arg0) {
        driver.findElement(By.id("username")).sendKeys("admin");
    }

    @And("^I press submit$")
    public void iPressSubmit() {
        driver.findElement(By.id("signin")).submit();
    }

    @Then("^I should see the following on the screen$")
    public void iShouldSeeTheFollowingOnTheScreen(Object checklist) {
        new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h2"),"Order details"));
    }

    @When("^I go to the page with a list of orders$")
    public void iClickTheOrdersListLink() {
        driver.navigate().to("http://localhost:8080/listOrders");
    }

    @Then("^I should see a list cointaining \"([^\"]*)\"$")
    public void iShouldSeeAListCointaining(String arg0) throws Throwable {

    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() {
    }
}
