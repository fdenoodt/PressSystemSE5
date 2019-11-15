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

    public static int isEvenGetal() {
        return or(eq(1), gt(1))*2;
    }


    @Before
    public void setUp() {
        pressOrder = mock(PressOrderMock.class);

        Mockito.when(pressOrder.maakAppelsap(meerOfGelijk50FruitStukken()))
                .thenReturn(true); // met param??

        Mockito.when(pressOrder.maakAppelsap(not(meerOfGelijk50FruitStukken())))
                .thenReturn(false);

        Mockito.when(pressOrder.maakPerensap(meerOfGelijk50FruitStukken()))
                .thenReturn(true);

        Mockito.when(pressOrder.maakPerensap(not(meerOfGelijk50FruitStukken())))
                .thenReturn(false);

        Mockito.when(pressOrder.maakConfituur(not(isEvenGetal())))
                .thenReturn(0);

        Mockito.when(pressOrder.maakConfituur(isEvenGetal()))
                .thenReturn(20);


    }

    @Gegeven("^Particulier bevindt zich op de bestelpagina$")
    public void particulierBevindtZichOpDeBestelpagina() {

    }

    //    int globalPeerAantal = 0;
    int aantalPerenFlessen = 0;

    @Als("^Particulier (\\d+) peren afgeeft$")
    public void particulierPerenAfgeeft(int peren) {
        if (pressOrder.maakPerensap(peren)) {
            aantalPerenFlessen = (peren / 4) + 1;
        } else {
            aantalPerenFlessen = (peren / 4);
        }
    }

    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen perensap moeten krijgen$")
    public void zouDeParticulierGratisFlessenPerensapMoetenKrijgen(int aantalFlessen, int bonus) {
        assertThat(aantalPerenFlessen).isEqualTo(aantalFlessen + bonus);
    }


    int aantalAppelFlessen = 0;

    //@Test
    @Als("^particulier (\\d+) appels afgeeft$")
    public void particulierAppelsAfgeeft(int appelen) {
        if (pressOrder.maakAppelsap(appelen)) {
            aantalAppelFlessen = (appelen / 3) + 1;
        } else {
            aantalAppelFlessen = (appelen / 3);
        }
    }

    //@Test
    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen appelsap moeten krijgen$")
    public void zouDeParticulierFlessenAppelsapMoetenKrijgen(int aantalFlessen, int bonus) {
        assertThat(aantalAppelFlessen).isEqualTo(aantalFlessen + bonus);
    }

    int kersenPotten = 0;

    @Als("^particulier (\\d+) kilogram afgeeft$")
    public void particulierKiloKersenAfgeeft(int kersenKg) {
        kersenPotten = pressOrder.maakConfituur(kersenKg)/2;
    }

    @Dan("^zou de particulier (\\d+) potten confituur moeten krijgen$")
    public void zouDeParticulierPottenConfituurMoetenKrijgen(int aantalPottenConfituur) {
        if (kersenPotten != 0)
            assertThat(aantalPottenConfituur).isEqualTo(kersenPotten);
        else
            assertThat(kersenPotten).isEqualTo(0);
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
