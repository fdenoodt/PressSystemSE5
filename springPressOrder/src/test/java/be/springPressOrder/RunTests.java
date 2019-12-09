package be.springPressOrder;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Cucumber.class)
//@RunWith(SerenityRunner.class)
//@WithTag("scrum:cheetahs")
@CucumberOptions(
        format = {"pretty",
                "html:target/cucumber"},
        features = {"classpath:be.springPressOrder"},
        tags = {"~@skip"})
public class RunTests {
//    @Steps
//    private Test123 steps;

//    @Step("Given a member has {0} points")
//    public void aMemberHasPointsOf(int points) {
//        System.out.println("hi");
//    }
//
//    @Step("Then the member grade should be {0}")
//    public void theMemberShouldHaveAStatusOf() {
//        assertThat(true).isEqualTo(true);
//    }

}


