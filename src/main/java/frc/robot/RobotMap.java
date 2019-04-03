/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Drivetrain CAN IDs
    public static final int LEFT_TALON = 5, RIGHT_TALON = 3, LEFT_VICTOR = 4, RIGHT_VICTOR = 6;

    // Conveyor PWM port
    public static final int CONVEYOR_SPARK = 0;

    // Hatch Mechanism solenoids
    public static final int EXTENDER_SOLENOID_F = 1;
    public static final int EXTENDER_SOLENOID_R = 6;

    public static final int RELEASER_SOLENOID_F = 7;
    public static final int RELEASER_SOLENOID_R = 0;

    public static final int ELEVATOR_TALON = 0;

    public static final int INTAKE_SPARK = 1;

    public static final int INTAKE_F = 5;
    public static final int INTAKE_R = 2;

}
