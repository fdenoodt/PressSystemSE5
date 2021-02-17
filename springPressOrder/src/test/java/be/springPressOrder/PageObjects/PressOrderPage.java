package be.springPressOrder.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PressOrderPage extends AbstractPage {
    public PressOrderPage(WebDriver driver) {
        super(driver);
    }

    public void voerAppelenIn(int aantalFruit) {
        voerFruitIn(aantalFruit);
        selecteerAppelInCombobox();
    }

    public void voerPerenIn(int aantalFruit) {
        voerFruitIn(aantalFruit);
        selecteerPeerInCombobox();
    }

    private void voerFruitIn(int aantalFruit) {
        driver.findElement(By.id("fruitAmount")).sendKeys(String.valueOf(aantalFruit));
    }

    private void selecteerAppelInCombobox() {
        selecteerFruitTypeInCombobox("1");
    }

    private void selecteerPeerInCombobox() {
        selecteerFruitTypeInCombobox("2");
    }

    private void selecteerFruitTypeInCombobox(String type) {
        Select select = new Select(driver.findElement(By.id("fruitId")));
        select.selectByValue(type);
    }

    public void bevestigPersOrder() {
        driver.findElement(By.id("btnSubmit")).click();
    }

    public String bekijkFoutMelding() {
        return driver.findElement(By.id("msgError")).getText();
    }

    public String bekijkResultaat() {
        return driver.findElement(By.id("resultaat")).getText();
    }

}
