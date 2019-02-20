package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Pipeline;

public class VisionAlignment extends CommandBase {

    private static final double KP_TURN = 0.05;

    private static final double KP_DRIVE = 0.035;

    private Pipeline pipeline;

    private double tx, ty;

    @Override
    protected void initialize() {
        pipeline = new Pipeline((byte)0);
    }

    @Override
    protected void execute() {

        if (OI.getDriverRightBumper()) {
            pipeline.setEntry("camMode", 0);
            pipeline.setEntry("ledMode", 0);

            if (pipeline.getEntry("tv") == 1) {
                tx = pipeline.getEntry("tx");
                ty = pipeline.getEntry("ty");

                double steeringAdjust = 0;
                double distanceAdjust = 0;

                if (Math.abs(tx) > 1) {
                    steeringAdjust = tx * KP_TURN;
                }

                if (Math.abs(ty) > 1) {
                    distanceAdjust = ty * KP_DRIVE;
                }

                driveTrain.tankDrive((distanceAdjust + steeringAdjust), (distanceAdjust - steeringAdjust));
            }


        } else {
            pipeline.setEntry("camMode", 1);
            pipeline.setEntry("ledMode", 1);
        }

        SmartDashboard.putNumber("Limelight X", tx);
        SmartDashboard.putNumber("Limelight Y", ty);

    }
}
