package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Debouncer;
import frc.robot.OI;

public class HatchGrabberControl extends CommandBase {

    private Debouncer debouncer;

    @Override
    protected void initialize() {
        // Create a debouncer for the toggle button
        debouncer = new Debouncer(OI.getOperatorController(), OI.A_BUTTON);
    }

    @Override
    protected void execute() {

        // Toggle for extending the mechanism
        if (debouncer.get()) {
            if (hatchGrabber.getExtender() == DoubleSolenoid.Value.kForward) {
                hatchGrabber.setExtender(DoubleSolenoid.Value.kReverse);
            } else {
                hatchGrabber.setExtender(DoubleSolenoid.Value.kForward);
            }
        }

        // Push to release hatch panel
        if (OI.getOperatorLB()) {
            hatchGrabber.setHatchReleaser(DoubleSolenoid.Value.kForward);
        } else {
            hatchGrabber.setHatchReleaser(DoubleSolenoid.Value.kReverse);
        }

    }
}
