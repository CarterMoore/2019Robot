package frc.robot.commands;

import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.MotionProfile;
import frc.robot.OI;

public class RunMotionProfile extends CommandBase {

    private final double WHEEL_DIAMETER = 0.5; // Wheel diameter of 0.5 feet (6 inches)
    private final double PULSES_PER_ROTATION = 4096; // Quadrature mag encoder has 4096 pulses per rotation

    private enum States {FILLING, EXCECUTING, FINISHED}

    private States state;

    private WPI_TalonSRX leftTalon;
    private WPI_TalonSRX rightTalon;

    private MotionProfile profile;

    private boolean isReversed;

    private BufferedTrajectoryPointStream bufferL = new BufferedTrajectoryPointStream();
    private BufferedTrajectoryPointStream bufferR = new BufferedTrajectoryPointStream();

    public RunMotionProfile(MotionProfile profile, boolean isReversed) {
        this.profile = profile;
        this.leftTalon = driveTrain.getLeftTalon();
        this.rightTalon = driveTrain.getRightTalon();

        this.isReversed = isReversed;

        state = States.FILLING;
    }

    @Override
    protected void initialize() {
        if (!isReversed) {
            startBuffer(profile.getLeftPath(), bufferL);
            startBuffer(profile.getRightPath(), bufferR);
        } else {
            startBuffer(profile.getLeftPathRev(), bufferL);
            startBuffer(profile.getRightPathRev(), bufferR);
        }
    }

    @Override
    protected void execute() {

        switch (state) {

            case FILLING:
                leftTalon.startMotionProfile(bufferL, 10, ControlMode.MotionProfile);
                rightTalon.startMotionProfile(bufferR, 10, ControlMode.MotionProfile);
                System.out.println("MP started");
                state = States.EXCECUTING;
                break;
            case EXCECUTING:
                if (leftTalon.isMotionProfileFinished() && rightTalon.isMotionProfileFinished()) {
                    System.out.println("MP finished");
                    state = States.FINISHED;
                }
                break;
            case FINISHED:
                this.end();
                break;
        }

    }

    private void startBuffer(double[][] profile, BufferedTrajectoryPointStream buffer) {

        TrajectoryPoint point = new TrajectoryPoint();

        buffer.Clear();

        for (int i = 0; i < profile.length; i++) {
            double pos = profile[i][1]; // Feet
            double vel = profile[i][2]; // Feet / s

            point.timeDur = (int) (profile[i][0] * 1000); // Convert seconds to ms
            point.position = pos * (PULSES_PER_ROTATION / (WHEEL_DIAMETER * Math.PI)); // Convert feet to units
            point.velocity = vel * (PULSES_PER_ROTATION / (WHEEL_DIAMETER * Math.PI)) / 10; // Convert ft/s to units/100ms

            point.auxiliaryPos = 0;
            point.auxiliaryVel = 0;

            point.profileSlotSelect0 = 0; // PID gain set 0
            point.profileSlotSelect1 = 0; // Auxiliary PID
            point.zeroPos = i == 0; // Set to true on first point
            point.isLastPoint = ((i + 1) == profile.length);
            point.arbFeedFwd = 0; // Constant offset to add

            buffer.Write(point);
        }

    }

    @Override
    protected void end() {
        driveTrain.stop();
    }

    @Override
    protected boolean isFinished() {
        return state == States.FINISHED || Math.abs(OI.getDriverLeftY()) > 0.4; // Stop if profile is finished or from driver override
    }
}
