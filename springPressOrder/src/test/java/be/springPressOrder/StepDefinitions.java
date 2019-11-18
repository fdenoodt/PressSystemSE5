package be.springPressOrder;

import cucumber.api.PendingException;
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
import static org.mockito.Mockito.mockingDetails;

public class StepDefinitions {
    @Mock
    private PressOrderMock pressOrder;
    private int aantalFruitstukken = 0;
    private String resultaat = "";

    public static int meerOfGelijkAan51Stukken() {
        return or(gt(51), eq(51));
    }

    public static int minderDan51Stukken() {
        return lt(51);
    }

    public static int meerOfGelijkAan3Appels() {
        return or(gt(3), eq(3));
    }

    public static int meerOfGelijkAan4Peren() {
        return or(gt(4), eq(4));
    }

    public static int minderDan3Appels() {
        return lt(3);
    }

    public static int minderDan4Peren() {
        return lt(4);
    }

    public static int meerDan100() {
        return gt(100);
    }


    @Before
    public void setUp() {
        pressOrder = mock(PressOrderMock.class);

        Mockito.when(pressOrder.maakAppelsap(meerDan100()))
                .thenReturn("Het max aantal stukken fruit is 100");

        Mockito.when(pressOrder.maakPerensap(meerDan100()))
                .thenReturn("Het max aantal stukken fruit is 100");

        Mockito.when(pressOrder.maakPerensap(minderDan4Peren()))
                .thenReturn("Het minimum aantal peren is 4");

        Mockito.when(pressOrder.maakAppelsap(minderDan3Appels()))
                .thenReturn("Het minimum aantal appels is 3");

//        Mockito.when(pressOrder.maakAppelsap(meerOfGelijkAan4Peren()))
//                .thenReturn(hetGetal / 4)
    }


    @Gegeven("^particulier heeft (\\d+) peren en wilt een pers-opdracht doen$")
    public void particulierHeeftPerenEnWiltEenPersOpdrachtDoen(int fruitstukken) {
        aantalFruitstukken = fruitstukken;
    }

    @Gegeven("^particulier heeft (\\d+) appelen en wilt een pers-opdracht doen$")
    public void particulierHeeftAppelenEnWiltEenPersOpdrachtDoen(int fruitstukken) {
        aantalFruitstukken = fruitstukken;
    }


    @Als("^de particulier deze peren afgeeft$")
    public void deParticulierDezePerenAfgeeft() {
        resultaat = pressOrder.maakPerensap(aantalFruitstukken);
    }

    @Als("^de particulier deze appelen afgeeft$")
    public void deParticulierDezeAppelenAfgeeft() {
        resultaat = pressOrder.maakAppelsap(aantalFruitstukken);
    }

    @Dan("^krijgt de particulier de volgende boodschap te zien: \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeBoodschapTeZien(String errorMessage) throws Throwable {
        assertThat(resultaat).isEqualTo(errorMessage);
    }

    @Dan("^krijgt de particulier (\\d+) flessen en (\\d+) bonus terug$")
    public void krijgtDeParticulierFlessenEnBonusTerug(int arg0, int arg1) {

    }

    @Dan("^krijgt de particulier (\\d+) flessen appelsap$")
    public void krijgtDeParticulierFlessenAppelsap(int arg0) {

    }

    @Dan("^krijgt de particulier (\\d+) flessen perensap$")
    public void krijgtDeParticulierFlessenPerensap(int arg0) {

    }

    @Dan("^krijgt de particulier (\\d+) en (\\d+)  flessen perensap$")
    public void krijgtDeParticulierEnFlessenPerensap(int arg0, int arg1) {

    }

    @Dan("^krijgt de particulier (\\d+) en (\\d+)  flessen appelen$")
    public void krijgtDeParticulierEnFlessenAppelen(int arg0, int arg1) {

    }

    @Dan("^krijgt de particulier de volgende foutmelding : \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeFoutmelding(String errorMessage) throws Throwable {
        assertThat(resultaat).isEqualTo(errorMessage);
    }


//
//    int globalPeerAantal = 0;
//    int aantalPerenFlessen = 0;
//
//    @Als("^Particulier (\\d+) peren afgeeft$")
//    public void particulierPerenAfgeeft(int peren) {
//        if (pressOrder.maakPerensap(peren)) {
//            aantalPerenFlessen = (peren / 4) + 1;
//        } else {
//            aantalPerenFlessen = (peren / 4);
//        }
//    }
//
//    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen perensap moeten krijgen$")
//    public void zouDeParticulierGratisFlessenPerensapMoetenKrijgen(int aantalFlessen, int bonus) {
//        assertThat(aantalPerenFlessen).isEqualTo(aantalFlessen + bonus);
//    }
//
//
//    int aantalAppelFlessen = 0;
//
//    //@Test
//    @Als("^particulier (\\d+) appels afgeeft$")
//    public void particulierAppelsAfgeeft(int appelen) {
//        if (pressOrder.maakAppelsap(appelen)) {
//            aantalAppelFlessen = (appelen / 3) + 1;
//        } else {
//            aantalAppelFlessen = (appelen / 3);
//        }
//    }
//
//    //@Test
//    @Dan("^zou de particulier (\\d+) \\+ (\\d+) gratis flessen appelsap moeten krijgen$")
//    public void zouDeParticulierFlessenAppelsapMoetenKrijgen(int aantalFlessen, int bonus) {
//        assertThat(aantalAppelFlessen).isEqualTo(aantalFlessen + bonus);
//    }
//
//    int kersenPotten = 0;
//
//    @Als("^particulier (\\d+) kilogram afgeeft$")
//    public void particulierKiloKersenAfgeeft(int kersenKg) {
//        kersenPotten = pressOrder.maakConfituur(kersenKg)/2;
//    }
//
//    @Dan("^zou de particulier (\\d+) potten confituur moeten krijgen$")
//    public void zouDeParticulierPottenConfituurMoetenKrijgen(int aantalPottenConfituur) {
//        if (kersenPotten != 0)
//            assertThat(aantalPottenConfituur).isEqualTo(kersenPotten);
//        else
//            assertThat(kersenPotten).isEqualTo(0);
//    }
//
//    @Als("^Particulier appel en peer kiest$")
//    public void particulierAppelEnPeerKiest() {
//    }
//
//    @Dan("^zou de particulier een melding krijgen dat hij maar (\\d+) soort fruit mag kiezen$")
//    public void zouDeParticulierEenMeldingKrijgenDatHijMaarSoortFruitMagKiezen(int arg0) {
//    }
//
//    @Als("^Particulier (\\d+)l flessen wenst$")
//    public void particulierLFlessenWenst(int arg0) {
//    }
//
//    @Dan("^zou zijn sap in (\\d+)l flessen moeten worden geplaatst$")
//    public void zouZijnSapInLFlessenMoetenWordenGeplaatst(int arg0) {
//    }
}
