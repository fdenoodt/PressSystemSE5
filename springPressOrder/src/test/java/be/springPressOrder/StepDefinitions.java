package be.springPressOrder;

import be.springPressOrder.domain.PressOrderCheckService;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.AdditionalMatchers.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    @Mock
    PressOrderCheckService pressOrderService;

    public static String validFruitTypes() {
        return or(eq("peer"), eq("appel"));
    }

    public static String appel() {
        return eq( "appel");
    }

    public static String peer() {
        return eq( "peer");
    }

    public static int minimumAantalPeren() {
        return gt(3);
    }

    public static int minimumAantalAppelen() {
        return gt(2);
    }

    @Before
    public void setUp() {
        initMocks(this);

        Mockito.when(pressOrderService.checkFruit(validFruitTypes())).thenReturn(true);

        Mockito.when(pressOrderService.checkFruit(not(validFruitTypes()))).thenReturn(false);

        Mockito.when(pressOrderService.checkFruitAmount(peer(), minimumAantalPeren()))
                .thenReturn("Order is geplaatst.");

        Mockito.when(pressOrderService.checkFruitAmount(appel(), minimumAantalAppelen()))
                .thenReturn("Order is geplaatst.");

        Mockito.when(pressOrderService.checkFruitAmount(peer(), not(minimumAantalPeren())))
                .thenReturn("Minimum aantal peren is 4 stuks.");

        Mockito.when(pressOrderService.checkFruitAmount(appel(), not(minimumAantalAppelen())))
                .thenReturn("Minimum aantal appels is 3 stuks.");

    }

    @Gegeven("^Particulier bevindt zich op de bestelpagina$")
    public void particulierBevindtZichOpDeBestelpagina() {

    }

    @Als("^Particulier (\\d+) peren afgeeft$")
    public void particulierPerenAfgeeft(int arg0) {

        assertThat(pressOrderService.checkFruitAmount("peer", arg0)).isEqualTo();
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
