package be.springPressOrder;

import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

public class StepDefinitions {
    @Mock
    PressOrderMock pressOrder;

    public static int meerOfGelijk50FruitStukken() {
        return or(eq(50), gt(50));
    }

    public static int meerOfGelijkAan1() {
        return or(eq(1), gt(1));
    }

    @Before
    public void setUp() {
        pressOrder = mock(PressOrderMock.class);

        Mockito.when(pressOrder.maakAppelsap(meerOfGelijk50FruitStukken()))
                .thenReturn(true);

        Mockito.when(pressOrder.maakAppelsap(not(meerOfGelijk50FruitStukken())))
                .thenReturn(false);

        Mockito.when(pressOrder.maakPerensap(meerOfGelijk50FruitStukken()))
                .thenReturn(true);

        Mockito.when(pressOrder.maakPerensap(not(meerOfGelijk50FruitStukken())))
                .thenReturn(false);

        Mockito.when(pressOrder.maakConfituur(not(meerOfGelijkAan1())))
                .thenReturn(false);

        Mockito.when(pressOrder.maakConfituur(meerOfGelijkAan1()))
                .thenReturn(true);


    }

    @Gegeven("^Particulier bevindt zich op de bestelpagina$")
    public void particulierBevindtZichOpDeBestelpagina() {

    }

    int globalPeerAantal = 0;

    @Als("^Particulier (\\d+) peren afgeeft$")
    public void particulierPerenAfgeeft(int peren) {
        globalPeerAantal = peren;
    }

    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen perensap moeten krijgen$")
    public void zouDeParticulierGratisFlessenPerensapMoetenKrijgen(int aantalFlessen, int bonus) {
        if (pressOrder.maakPerensap(globalPeerAantal))
            assertThat(aantalFlessen + bonus).isEqualTo((globalPeerAantal / 4) + 1);
        else
            assertThat(aantalFlessen).isEqualTo(globalPeerAantal / 4);
    }


    boolean aantalAppelSap = false;
    int globalAppelAantal = 0;

    //@Test
    @Als("^particulier (\\d+) appels afgeeft$")
    public void particulierAppelsAfgeeft(int appelen) {
        globalAppelAantal = appelen;
    }

    //@Test
    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen appelsap moeten krijgen$")
    public void zouDeParticulierFlessenAppelsapMoetenKrijgen(int aantalFlessen, int bonus) {
        if (pressOrder.maakAppelsap(globalAppelAantal))
            assertThat(aantalFlessen + bonus).isEqualTo((globalAppelAantal / 3) + 1);
        else
            assertThat(aantalFlessen).isEqualTo(globalAppelAantal / 3);
    }

    int kersenKg = 0;

    @Als("^particulier (\\d+) kilogram afgeeft$")
    public void particulierKiloKersenAfgeeft(int kersenKg) {
        this.kersenKg = kersenKg;

    }

    @Dan("^zou de particulier (\\d+) potten confituur moeten krijgen$")
    public void zouDeParticulierPottenConfituurMoetenKrijgen(int arg0) {
        assertThat(pressOrder.maakConfituur(kersenKg)).isEqualTo(true);
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
