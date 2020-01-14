package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Debouncer;
import frc.robot.MotionProfile;
import frc.robot.OI;

public class DriverControl extends CommandBase {

    @Override
    protected void execute() {
        driveTrain.arcadeDrive(-OI.getDriverLeftY(), OI.getDriverRightX());
    }

}
