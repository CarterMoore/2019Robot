package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.MotionProfile;
import frc.robot.commands.RunMotionProfile;

public class HabToFrontBay extends CommandGroup {

    public HabToFrontBay() {
        addParallel(new RunMotionProfile(new MotionProfile("lvl1tofrontbay"), false));
    }

}
