package frc.robot.commands;

import frc.robot.OI;

public class DriverControl extends CommandBase {

    @Override
    protected void execute() {
        driveTrain.arcadeDrive(-OI.getDriverLeftY(), OI.getDriverRightX());
    }

}
