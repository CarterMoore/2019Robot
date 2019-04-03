package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Intake extends Subsystem {

    private Spark intakeMotor;

    private DoubleSolenoid extender;

    private static Intake instance;

    public static Intake getInstance() {
        if (instance == null)
            instance = new Intake();
        return instance;
    }

    public Intake() {
        intakeMotor = new Spark(RobotMap.INTAKE_SPARK);
        extender = new DoubleSolenoid(RobotMap.EXTENDER_SOLENOID_F, RobotMap.RELEASER_SOLENOID_R);
    }

    public void run(double speed) {
        intakeMotor.set(speed);
    }

    public void setExtender(DoubleSolenoid.Value state) {
        extender.set(state);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
