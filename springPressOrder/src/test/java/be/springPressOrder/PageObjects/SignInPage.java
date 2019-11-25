package be.springPressOrder.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MainPage signIn(String email, String password) {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.id("btnSubmit")).click();
        return new MainPage(driver);
    }
}
