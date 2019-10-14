package be.springPressOrder.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class MachineStatusTest {
    private MachineStatusSimulator machineStatusSimulator;

    @Before
    public void init() {
        machineStatusSimulator = new MachineStatusSimulator();
    }

    @Test
    public void HoofdScenario(){
        assertEquals(Machine.Status.Ok, machineStatusSimulator.Getstatus());
        machineStatusSimulator.Setstatus(Machine.Status.Not_OK);
        assertEquals(Machine.Status.Not_OK, machineStatusSimulator.Getstatus());
        machineStatusSimulator.Setstatus(Machine.Status.Ok);
        assertEquals(Machine.Status.Ok, machineStatusSimulator.Getstatus());
    }
}
