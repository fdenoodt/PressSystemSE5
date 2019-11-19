package be.springPressOrder;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.persistence.Convert;

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

    public static int tussen3en50Appels() {
        return and(gt(2), lt(51));
    }

    public static int tussen4en50Peren() {
        return and(gt(3), lt(51));
    }

    public static int tussen51en100FruitStukken() {
        return and(gt(50), lt(101));
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

        Mockito.when(pressOrder.maakAppelsap(tussen3en50Appels()))
                .thenAnswer((Answer<String>) invocation -> {
                    int appels = Integer.valueOf(invocation.getArguments()[0].toString());
                    int flessen = appels / 3; // delen door int 3 om af te kappen naar beneden. Geen bonus
                    return String.valueOf(flessen);
                });

        Mockito.when(pressOrder.maakPerensap(tussen4en50Peren()))
                .thenAnswer((Answer<String>) invocation -> {
                    int peren = Integer.valueOf(invocation.getArguments()[0].toString());
                    int flessen = peren / 4; // delen door int 3 om af te kappen naar beneden. Geen bonus
                    return String.valueOf(flessen);
                });

        Mockito.when(pressOrder.maakAppelsap(tussen51en100FruitStukken()))
                .thenAnswer((Answer<String>) invocation -> {
                    int appels = Integer.valueOf(invocation.getArguments()[0].toString());
                    int flessen = (appels / 3) + 1; // + 1 want er is een bonus
                    return String.valueOf(flessen);
                });

        Mockito.when(pressOrder.maakPerensap(tussen51en100FruitStukken()))
                .thenAnswer((Answer<String>) invocation -> {
                    int peren = Integer.valueOf(invocation.getArguments()[0].toString());
                    int flessen = (peren / 4) + 1; // + 1 want er is een bonus
                    return String.valueOf(flessen);
                });

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
    public void krijgtDeParticulierFlessenEnBonusTerug(int flessen, int bonus) {
        String verwachtResultaat = String.valueOf(flessen + bonus);
        assertThat(resultaat).isEqualTo(verwachtResultaat);
    }

    @Dan("^krijgt de particulier de volgende foutmelding : \"([^\"]*)\"$")
    public void krijgtDeParticulierDeVolgendeFoutmelding(String errorMessage) throws Throwable {
        assertThat(resultaat).isEqualTo(errorMessage);
    }


}
