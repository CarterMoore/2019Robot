package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LEDs extends Subsystem {

    private static LEDs instance;

    public static LEDs getInstance() {
        if (instance == null)
            instance = new LEDs();
        return instance;
    }

    private Spark blinkin;

    private LEDs() {
        blinkin = new Spark(RobotMap.BLINKIN);
    }

    public void set(double output) {
        blinkin.set(output);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
