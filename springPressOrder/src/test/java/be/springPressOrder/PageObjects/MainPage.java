package be.springPressOrder.PageObjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public PressOrderPage navigateToPressOrderPage() {
        driver.navigate().to("http://localhost:8080/pressorder/new");
        return new PressOrderPage(driver);
    }
}
