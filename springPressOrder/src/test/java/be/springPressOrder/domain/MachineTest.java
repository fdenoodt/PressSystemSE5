package be.springPressOrder.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.security.auth.Subject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MachineTest {

    Machine machine;

    @Before
    public void setUp() throws Exception {
        machine = new Machine();
    }

    @Test
    // S0 - S1 - S2 - S3
    public void test1() {
        assertThat(machine.getStatus()).isEqualTo(Machine.Status.Ok);
        machine.changeStatus();
        machine = null;
        assertThat(machine).isEqualTo(null);

    }

    @Test
    // S0 - S1 - S2 - S1
    public void test2() {
        machine.changeStatus();
        assertThat(machine.getStatus()).isEqualTo(Machine.Status.Not_OK);

        machine.changeStatus();
        assertThat(machine.getStatus()).isEqualTo(Machine.Status.Ok);
    }

    @Test
    //S0 - S1 - S3
    public void test3() {
        assertThat(machine.getStatus()).isEqualTo(Machine.Status.Ok);

        machine = null;
        assertThat(machine).isEqualTo(null);
    }


}