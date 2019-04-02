package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Limelight;

public class VisionAlignment extends CommandBase {

    private static final int DRIVER_PIPELINE = 0, PROCESSING_PIPELINE = 1;

    private static final double KP_TURN = 0.05;

    private static final double KP_DRIVE = 0.035;

    private static final double MAX_TURN = 0.8, MAX_DRIVE = 0.7;

    private Limelight limelight;

    private double tx, ty;

    @Override
    protected void initialize() {
        limelight = new Limelight((byte)DRIVER_PIPELINE);
    }

    @Override
    protected void execute() {

        if (OI.getDriverRB()) {

            limelight.setEntry("pipeline", PROCESSING_PIPELINE);

            if (limelight.getEntry("tv") == 1) {
                tx = limelight.getEntry("tx");
                ty = limelight.getEntry("ty");

                double steeringAdjust = 0;
                double distanceAdjust = 0;

                if (Math.abs(tx) > 1) {
                    double sign = Math.abs(tx * KP_TURN) / (tx * KP_TURN);
                    steeringAdjust = sign * Math.min(Math.abs(tx * KP_TURN), MAX_TURN);
                }

                if (Math.abs(ty) > 1) {
                    distanceAdjust = Math.min(ty * KP_DRIVE, MAX_DRIVE);
                }

                driveTrain.arcadeDrive(distanceAdjust, steeringAdjust);

            }

        } else {
            limelight.setEntry("pipeline", DRIVER_PIPELINE);
        }

    }
}
