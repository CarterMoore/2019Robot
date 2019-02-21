package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Debouncer {

    private Joystick joystick;
    private int button;
    private double latest;
    private double period;

    public Debouncer(Joystick joystick, int button) {
        this.joystick = joystick;
        this.button = button;
        this.period = 0.3;
        this.latest = 0;
    }

    public Debouncer(Joystick joystick, int button, double period) {
        this.joystick = joystick;
        this.button = button;
        this.period = period;
        this.latest = 0;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public boolean get() {
        double now = Timer.getFPGATimestamp();
        if (joystick.getRawButton(button) ) {
            if ((now-latest > period)) {
                latest = now;
                return true;
            }
        }
        return false;
    }

}
