/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static final int DRIVER_CONTROLLER = 0, OPERATOR_CONTROLLER = 1;

    private static XboxController driver, operator;

    public static void init() {
        driver = new XboxController(DRIVER_CONTROLLER);
        operator = new XboxController(OPERATOR_CONTROLLER);
    }

    public static double getDriverLeftY() {
        return driver.getY(GenericHID.Hand.kLeft);
    }

    public static double getDriverRightX() {
        return driver.getX(GenericHID.Hand.kRight);
    }

    public static boolean getDriverRightBumper() {
        return driver.getBumper(GenericHID.Hand.kRight);
    }

    public static boolean getOperatorRightBumper() {
        return operator.getBumper(GenericHID.Hand.kRight);
    }

}
