package be.springPressOrder;

import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class Test123 {

    @Step("Given a member has {0} points")
    public void aMemberHasPointsOf(int points) {
        System.out.println("hi");
    }

    @Step("Then the member grade should be {0}")
    public void theMemberShouldHaveAStatusOf() {
        assertThat(true).isEqualTo(true);
    }
}
