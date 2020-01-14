package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.MotionProfile;
import frc.robot.commands.RunMotionProfile;

public class RightFrontCargoToRightLoading extends CommandGroup {

    public RightFrontCargoToRightLoading() {
        addSequential(new RunMotionProfile(new MotionProfile("rfb-rs-1-(r)"), true));
        addSequential(new RunMotionProfile(new MotionProfile("rfb-rs-2"), false));
    }
}
