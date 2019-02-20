package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DriveTrain;

public class CommandBase extends Command {

    static DriveTrain driveTrain;
    static Conveyor conveyor;

    public static void init() {
        OI.init();

        driveTrain = DriveTrain.getInstance();
        conveyor = Conveyor.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
