package be.springPressOrder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertTrue;

public class StepDefinitions {

    @Gegeven("^Particulier bevindt zich op de bestelpagina$")
    public void particulierBevindtZichOpDeBestelpagina() {
        
    }

    @Als("^Particulier (\\d+) peren afgeeft$")
    public void particulierPerenAfgeeft(int arg0) {
    }

    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen perensap moeten krijgen$")
    public void zouDeParticulierGratisFlessenPerensapMoetenKrijgen(int arg0, int arg1) {
    }

    @Als("^particulier (\\d+) appels afgeeft$")
    public void particulierAppelsAfgeeft(int arg0) {
    }

    @Dan("^zou de particulier (\\d+) flessen appelsap moeten krijgen$")
    public void zouDeParticulierFlessenAppelsapMoetenKrijgen(int arg0) {
    }

    @Als("^particulier (\\d+) kilo kersen afgeeft$")
    public void particulierKiloKersenAfgeeft(int arg0) {
    }

    @Dan("^zou de particulier (\\d+) potten confituur moeten krijgen$")
    public void zouDeParticulierPottenConfituurMoetenKrijgen(int arg0) {
    }

    @Als("^Particulier appel en peer kiest$")
    public void particulierAppelEnPeerKiest() {
    }

    @Dan("^zou de particulier een melding krijgen dat hij maar (\\d+) soort fruit mag kiezen$")
    public void zouDeParticulierEenMeldingKrijgenDatHijMaarSoortFruitMagKiezen(int arg0) {
    }

    @Als("^Particulier (\\d+)l flessen wenst$")
    public void particulierLFlessenWenst(int arg0) {
    }

    @Dan("^zou zijn sap in (\\d+)l flessen moeten worden geplaatst$")
    public void zouZijnSapInLFlessenMoetenWordenGeplaatst(int arg0) {
    }
}
