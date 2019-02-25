package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HatchGrabber extends Subsystem {

    private DoubleSolenoid hatchReleaser;
    private DoubleSolenoid extender;

    private static HatchGrabber instance;

    public static HatchGrabber getInstance() {
        if (instance == null)
            instance = new HatchGrabber();
        return instance;
    }

    private HatchGrabber() {
        hatchReleaser = new DoubleSolenoid(RobotMap.RELEASER_SOLENOID_F, RobotMap.RELEASER_SOLENOID_R);
        extender = new DoubleSolenoid(RobotMap.EXTENDER_SOLENOID_F, RobotMap.EXTENDER_SOLENOID_R);
    }

    public void setExtenderState(DoubleSolenoid.Value state) {
        extender.set(state);
    }

    public void setHatchReleaserState(DoubleSolenoid.Value state) {
        hatchReleaser.set(state);
    }

    public DoubleSolenoid.Value getExtenderState() {
        return extender.get();
    }

    @Override
    protected void initDefaultCommand() {

    }
}
