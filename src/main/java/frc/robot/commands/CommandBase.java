package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.*;

public class CommandBase extends Command {

    static DriveTrain driveTrain;
    static Conveyor conveyor;
    static HatchGrabber hatchGrabber;
    static Intake intake;
    static Lift lift;
    static LEDs leds;

    public static void init() {
        driveTrain = DriveTrain.getInstance();
        conveyor = Conveyor.getInstance();
        hatchGrabber = HatchGrabber.getInstance();
        intake = Intake.getInstance();
        lift = Lift.getInstance();
        leds = LEDs.getInstance();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
