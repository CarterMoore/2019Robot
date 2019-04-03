package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Debouncer;
import frc.robot.OI;

public class IntakeControl extends CommandBase {

    Debouncer debouncer = new Debouncer(OI.getOperatorController(), OI.X_BUTTON);

    @Override
    protected void execute() {
        if (OI.getOperatorRB() && intake.getIntakeExtenderState() == DoubleSolenoid.Value.kForward) {
            intake.runIntake(0.4);
        }

        if (debouncer.get()) {
            if (intake.getIntakeExtenderState() == DoubleSolenoid.Value.kForward) {
                intake.setIntakeExtenderState(DoubleSolenoid.Value.kReverse);
            } else {
                intake.setIntakeExtenderState(DoubleSolenoid.Value.kForward);
            }
        }

    }
}
