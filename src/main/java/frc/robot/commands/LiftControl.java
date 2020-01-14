package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Debouncer;
import frc.robot.OI;

public class LiftControl extends CommandBase {

    private Debouncer debouncer;

    @Override
    protected void initialize() {
        debouncer = new Debouncer(OI.getDriverController(), OI.Y_BUTTON);
    }

    @Override
    protected void execute() {
        if (debouncer.get()) {
            if (lift.getLiftState() == DoubleSolenoid.Value.kReverse) {
                lift.setLiftState(DoubleSolenoid.Value.kForward);
            } else {
                lift.setLiftState(DoubleSolenoid.Value.kReverse);
            }
        }
        if (OI.getDriverSelect()) {
            lift.runElevator(0.5);
        } else if (OI.getDriverStart()) {
            lift.runElevator(-0.5);
        } else {
            lift.runElevator(0);
        }
    }
}
