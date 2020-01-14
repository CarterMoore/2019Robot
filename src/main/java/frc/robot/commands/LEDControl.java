package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;

public class LEDControl extends CommandBase{

    private DriverStation driverStation;

    @Override
    protected void initialize() {
        driverStation = DriverStation.getInstance();
    }

    @Override
    protected void execute() {
//        if (driverStation.getMatchTime() >=30) {
//            if (driverStation.getAlliance().equals(DriverStation.Alliance.Blue)) {
//                leds.set(0.87);
//            } else if (driverStation.getAlliance().equals(DriverStation.Alliance.Red)) {
//                leds.set(0.61);
//            }
//        } else if (driverStation.getMatchTime() >= 20 && driverStation.getMatchTime() <= 30) {
//            if (driverStation.getAlliance().equals(DriverStation.Alliance.Blue)) {
//                leds.set(0.03);
//            } else if (driverStation.getAlliance().equals(DriverStation.Alliance.Red)) {
//                leds.set(0.23);
//            }
//        } else if (driverStation.getMatchTime() <= 20 && driverStation.getMatchTime() >= 10) {
//            if (driverStation.getAlliance().equals(DriverStation.Alliance.Blue)) {
//                leds.set(0.05);
//            } else if (driverStation.getAlliance().equals(DriverStation.Alliance.Red)) {
//                leds.set(0.25);
//            }
//        } 
    }
}
