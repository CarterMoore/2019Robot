package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Debouncer;
import frc.robot.OI;
import frc.robot.Limelight;

public class VisionAlignment extends CommandBase {

    private static final int DRIVER_PIPELINE = 0, PROCESSING_PIPELINE = 1;

    private static final double KP_TURN = 0.05;

    private static final double KP_DRIVE = 0.035;

    private static final double MAX_DRIVE = 0.5;

    private static final double MIN_TURN = 0.1;

    private static final double TARGET_AREA = 0;

    private Limelight limelight;

    private Debouncer debouncer;

    private int currentPipeline;

    private double tx, ta;

    @Override
    protected void initialize() {
        limelight = new Limelight((byte)DRIVER_PIPELINE);
        debouncer = new Debouncer(OI.getDriverController(), OI.LB);
        currentPipeline = DRIVER_PIPELINE;
    }

    @Override
    protected void execute() {

        if (debouncer.get()) {
            if (currentPipeline == DRIVER_PIPELINE) {
                limelight.setEntry("pipeline", PROCESSING_PIPELINE);
                currentPipeline = PROCESSING_PIPELINE;
            } else {
                limelight.setEntry("pipeline", DRIVER_PIPELINE);
                currentPipeline = DRIVER_PIPELINE;
            }
        }

        if (OI.getDriverRB()) {

            limelight.setEntry("pipeline", PROCESSING_PIPELINE);
            currentPipeline = PROCESSING_PIPELINE;

            if (limelight.getEntry("tv") == 1) {
                tx = limelight.getEntry("tx");
                ta = limelight.getEntry("ta");

                double steeringAdjust = 0;

                double distanceAdjust = Math.min((TARGET_AREA - ta) * KP_DRIVE, MAX_DRIVE);

                if (tx > 1) {
                    steeringAdjust = tx * KP_TURN + MIN_TURN;
                }

                if (tx < -1) {
                    steeringAdjust = tx * KP_TURN - MIN_TURN;
                }

                driveTrain.arcadeDrive(distanceAdjust, steeringAdjust);

            }

        } else {
            limelight.setEntry("pipeline", DRIVER_PIPELINE);
            currentPipeline = DRIVER_PIPELINE;
        }

    }
}
