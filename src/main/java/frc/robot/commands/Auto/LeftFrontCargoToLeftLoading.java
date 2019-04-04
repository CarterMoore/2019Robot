package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.MotionProfile;
import frc.robot.commands.RunMotionProfile;

public class LeftFrontCargoToLeftLoading extends CommandGroup {

    public LeftFrontCargoToLeftLoading() {
        addSequential(new RunMotionProfile(new MotionProfile("lfb-ls-1-(r)"), true));
        addSequential(new RunMotionProfile(new MotionProfile("lfb-ls-2"), false));
    }
}
