package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchGrabber;

public class CommandBase extends Command {

    static DriveTrain driveTrain;
    static Conveyor conveyor;
    static HatchGrabber hatchGrabber;

    public static void init() {
        driveTrain = DriveTrain.getInstance();
        conveyor = Conveyor.getInstance();
        hatchGrabber = HatchGrabber.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
