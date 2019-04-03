package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Debouncer;
import frc.robot.OI;

public class HatchGrabberControl extends CommandBase {

    private Debouncer aDebouncer;
    private Debouncer bDebouncer;

    @Override
    protected void initialize() {
        // Create a debouncer for the toggle button
        aDebouncer = new Debouncer(OI.getOperatorController(), OI.A_BUTTON);
        bDebouncer = new Debouncer(OI.getOperatorController(), OI.B_BUTTON, 0.25);
    }

    @Override
    protected void execute() {

        // Toggle for extending the mechanism
        if (aDebouncer.get()) {
            if (hatchGrabber.getExtenderState() == DoubleSolenoid.Value.kForward) {
                hatchGrabber.setExtenderState(DoubleSolenoid.Value.kReverse);
            } else {
                hatchGrabber.setExtenderState(DoubleSolenoid.Value.kForward);
            }
        }

        // Push to release hatch panel
        if (bDebouncer.get()) {
            new PlaceHatch().start();
        }

    }
}
