package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.MotionProfile;
import frc.robot.commands.RunMotionProfile;

public class RightLoadingToRightBay1 extends CommandGroup {

    public RightLoadingToRightBay1() {
        addSequential(new RunMotionProfile(new MotionProfile("rs-r1b-1-(r)"), true));
        addSequential(new RunMotionProfile(new MotionProfile("rs-r1b-2"), false));
    }
}
