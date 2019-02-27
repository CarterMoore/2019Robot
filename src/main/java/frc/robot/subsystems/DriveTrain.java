package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {

    private WPI_TalonSRX leftTalon, rightTalon;

    private DifferentialDrive drive;

    private static DriveTrain instance;

    // TODO test and find PIDF constants
    private static final double NEUTRAL_DEADBAND = 0.01, kF = 0.0, kP = 0.0, kI = 0.0, kD = 0.0, PEAK_OUTPUT = 0.9;

    private static final double PULSES_PER_ROTATION = 4096, WHEEL_DIAMETER = 0.5;

    private static final int I_ZONE = 0;

    public static DriveTrain getInstance() {
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    private DriveTrain() {

        leftTalon = new WPI_TalonSRX(RobotMap.LEFT_TALON);
        rightTalon = new WPI_TalonSRX(RobotMap.RIHGT_TALON);

        // Reset to defaults on boot to make sure settings are known
        leftTalon.configFactoryDefault();
        rightTalon.configFactoryDefault();

        TalonSRXConfiguration talonSRXConfig = new TalonSRXConfiguration();

        talonSRXConfig.primaryPID.selectedFeedbackSensor = FeedbackDevice.CTRE_MagEncoder_Relative; // Quadrature mag encoder
        talonSRXConfig.neutralDeadband = NEUTRAL_DEADBAND;
        talonSRXConfig.slot0.kF = kF;
        talonSRXConfig.slot0.kP = kP;
        talonSRXConfig.slot0.kI = kI;
        talonSRXConfig.slot0.kD = kD;
        talonSRXConfig.slot0.integralZone = I_ZONE;
        talonSRXConfig.slot0.closedLoopPeakOutput = PEAK_OUTPUT;

        leftTalon.configAllSettings(talonSRXConfig);
        rightTalon.configAllSettings(talonSRXConfig);

        WPI_VictorSPX leftVictor = new WPI_VictorSPX(RobotMap.LEFT_VICTOR);
        WPI_VictorSPX rightVictor = new WPI_VictorSPX(RobotMap.RIGHT_VICTOR);

        // Reset to defaults for same reason as talons
        leftVictor.configFactoryDefault();
        rightVictor.configFactoryDefault();

        VictorSPXConfiguration victorSPXConfig = new VictorSPXConfiguration();

        victorSPXConfig.neutralDeadband = NEUTRAL_DEADBAND;

        leftVictor.configAllSettings(victorSPXConfig);
        rightVictor.configAllSettings(victorSPXConfig);

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

    public WPI_TalonSRX getLeftTalon() {
        return leftTalon;
    }

    public WPI_TalonSRX getRightTalon() {
        return rightTalon;
    }

    public void stop() {
        leftTalon.stopMotor();
        rightTalon.stopMotor();
    }

    public void log() {
        SmartDashboard.putNumber("Left Wheel speed", leftTalon.getSelectedSensorVelocity() * 10 * ((WHEEL_DIAMETER * Math.PI) / PULSES_PER_ROTATION));
        SmartDashboard.putNumber("Right Wheel speed", rightTalon.getSelectedSensorVelocity() * 10 * ((WHEEL_DIAMETER * Math.PI) / PULSES_PER_ROTATION));
    }
    @Override
    protected void initDefaultCommand() {

    }
}
