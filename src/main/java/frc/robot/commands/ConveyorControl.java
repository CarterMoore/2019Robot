package frc.robot.commands;

import frc.robot.OI;

public class ConveyorControl extends CommandBase {

    @Override
    protected void execute() {

        if (OI.getOperatorRB()) {
            conveyor.runForward();
        } else {
            conveyor.stop();
        }

    }
}
