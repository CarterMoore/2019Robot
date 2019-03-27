package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

public class Conveyor {

    private Spark conveyorMotor;

    private static Conveyor instance;

    public static Conveyor getInstance() {
        if (instance == null)
            instance = new Conveyor();
        return instance;
    }

    private Conveyor() {
        conveyorMotor = new Spark(RobotMap.CONVEYOR_SPARK);
    }

    public void runForward(double speed) {
        conveyorMotor.set(-speed);
    }

    public void runBackward() {
        conveyorMotor.set(0.6);
    }

    public void stop() {
        conveyorMotor.set(0);
    }

}
