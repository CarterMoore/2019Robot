package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX leftTalon, rightTalon;

    private DifferentialDrive drive;

    private static DriveTrain instance;

    public static DriveTrain getInstance() {
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    private DriveTrain() {

        leftTalon = new WPI_TalonSRX(RobotMap.LEFT_TALON);
        rightTalon = new WPI_TalonSRX(RobotMap.RIHGT_TALON);

        leftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        rightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

        WPI_VictorSPX leftVictor = new WPI_VictorSPX(RobotMap.LEFT_VICTOR);
        WPI_VictorSPX rightVictor = new WPI_VictorSPX(RobotMap.RIGHT_VICTOR);

        leftVictor.follow(leftTalon);
        rightVictor.follow(rightTalon);

        drive = new DifferentialDrive(leftTalon, rightTalon);

    }

    public void arcadeDrive(double speed, double rot) {
        drive.arcadeDrive(speed, rot);
    }

    public void tankDrive(double lSpeed, double rSpeed) {
        drive.tankDrive(lSpeed, rSpeed);
    }

    public static WPI_TalonSRX getLeftTalon() {
        return leftTalon;
    }

    public static WPI_TalonSRX getRightTalon() {
        return rightTalon;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
