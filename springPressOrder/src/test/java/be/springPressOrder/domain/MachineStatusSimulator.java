package be.springPressOrder.domain;

public class MachineStatusSimulator {
    private Machine machine;

    public MachineStatusSimulator() {
        machine = new Machine(1,false,100);
    }

    public Machine.Status Getstatus() {
        return machine.getStatus();
    }

    public String Setstatus(Machine.Status status) {
        machine.setStatus(status);
        return "successfully saved";
    }
}
