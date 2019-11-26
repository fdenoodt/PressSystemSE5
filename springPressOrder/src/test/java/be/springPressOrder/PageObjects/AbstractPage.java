package be.springPressOrder.PageObjects;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = driver;
    }

    public SignInPage navigateToSignInPage() {
        driver.navigate().to("http://localhost:8080/login");
        return new SignInPage(driver);
    }

    public void closeDriver() {
        driver.quit();
    }

}

