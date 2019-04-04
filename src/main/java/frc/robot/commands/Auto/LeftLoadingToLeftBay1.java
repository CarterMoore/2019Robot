package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.MotionProfile;
import frc.robot.commands.RunMotionProfile;

public class LeftLoadingToLeftBay1 extends CommandGroup {

    public LeftLoadingToLeftBay1() {
        addSequential(new RunMotionProfile(new MotionProfile("ls-l1b-1-(r)"), true));
        addSequential(new RunMotionProfile(new MotionProfile("ls-l1b-2"), false));
    }
}
