package frc.robot.commands;

import frc.robot.Debouncer;
import frc.robot.OI;

public class IntakeControl extends CommandBase {

    private Debouncer debouncer;

    @Override
    protected void initialize() {
        debouncer = new Debouncer(OI.getOperatorController(), OI.X_BUTTON);
    }

    @Override
    protected void execute() {
        if (debouncer.get()) {

        }
    }
}
