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
            if (hatchGrabber.getExtenderState() == DoubleSolenoid.Value.kForward) {
                hatchGrabber.setExtenderState(DoubleSolenoid.Value.kReverse);
            } else {
                hatchGrabber.setExtenderState(DoubleSolenoid.Value.kForward);
            }
        }

        // Push to release hatch panel
        if (OI.getOperatorLB()) {
            hatchGrabber.setHatchReleaserState(DoubleSolenoid.Value.kForward);
        } else {
            hatchGrabber.setHatchReleaserState(DoubleSolenoid.Value.kReverse);
        }

    }
}
