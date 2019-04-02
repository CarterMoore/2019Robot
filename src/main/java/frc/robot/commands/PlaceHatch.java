package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceHatch extends CommandGroup {

    public PlaceHatch() {
        addSequential(new HatchReleaser(DoubleSolenoid.Value.kForward), 0.2);
        addSequential(new HatchExtender(DoubleSolenoid.Value.kReverse), 0.3);
        addParallel(new HatchReleaser(DoubleSolenoid.Value.kReverse));
    }
}
