package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Lift extends Subsystem {

    private DoubleSolenoid liftPiston;

    private WPI_TalonSRX liftElevator;

    private static Lift instance;

    public static Lift getInstance() {
        if (instance == null)
            instance = new Lift();
        return instance;
    }

    public Lift() {
        liftPiston = new DoubleSolenoid(RobotMap.LIFT_F, RobotMap.LIFT_R);
        liftElevator = new WPI_TalonSRX(RobotMap.ELEVATOR_TALON);

        liftElevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        liftElevator.configForwardSoftLimitEnable(true);
        liftElevator.configReverseSoftLimitEnable(true);
        liftElevator.configForwardSoftLimitThreshold(0);
        liftElevator.configReverseSoftLimitThreshold(-5900);
    }

    public void setLiftState(DoubleSolenoid.Value state) {
        liftPiston.set(state);
    }

    public DoubleSolenoid.Value getLiftState() {
        return liftPiston.get();
    }

    public void runElevator(double speed) {
        liftElevator.set(ControlMode.PercentOutput, speed);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
