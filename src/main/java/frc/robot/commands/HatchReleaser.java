package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class HatchReleaser extends CommandBase {

    private DoubleSolenoid.Value state;

    public HatchReleaser(DoubleSolenoid.Value state) {
        this.state = state;
        setTimeout(0);
    }

    public HatchReleaser(DoubleSolenoid.Value state, double timeout) {
        this.state = state;
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        hatchGrabber.setHatchReleaserState(state);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
