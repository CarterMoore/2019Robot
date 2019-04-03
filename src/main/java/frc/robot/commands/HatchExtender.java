package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class HatchExtender extends CommandBase {

    private DoubleSolenoid.Value state;

    public HatchExtender(DoubleSolenoid.Value state) {
        this.state = state;
        setTimeout(0);
    }

    public HatchExtender(DoubleSolenoid.Value state, double timeout) {
        this.state = state;
        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        hatchGrabber.setExtenderState(state);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
