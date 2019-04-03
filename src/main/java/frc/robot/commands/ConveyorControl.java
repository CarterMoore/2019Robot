package frc.robot.commands;

import frc.robot.OI;

public class ConveyorControl extends CommandBase {

    @Override
    protected void execute() {
        if (OI.getOperatorRB()) {
            conveyor.runForward(0.8);
        } else if (OI.getOperatorLB()){
            conveyor.runForward(0.6);
        } else {
            conveyor.stop();
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
