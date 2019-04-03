package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

public class Intake extends Subsystem {

    private DoubleSolenoid intakeExtender;

    private Spark intakeMotor;

    private static Intake instance;

    public static Intake getInstance() {
        if (instance == null)
            instance = new Intake();
        return instance;
    }

    private Intake() {
        intakeExtender = new DoubleSolenoid(RobotMap.INTAKE_F, RobotMap.INTAKE_R);
        intakeMotor = new Spark(RobotMap.INTAKE_SPARK);
    }

    public void setIntakeExtenderState(DoubleSolenoid.Value state) {
        intakeExtender.set(state);
    }

    public DoubleSolenoid.Value getIntakeExtenderState() {
        return intakeExtender.get();
    }

    public void runIntake(double speed) {
        intakeMotor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
