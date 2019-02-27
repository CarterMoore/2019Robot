/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.*;

public class Robot extends TimedRobot {

  private Compressor compressor;

  @Override
  public void robotInit() {
      CommandBase.init();
      OI.init();
      try {
          CameraServer.getInstance().startAutomaticCapture();
      } catch (Exception e) {
          System.out.println("No camera connected");
      }

      compressor = new Compressor();
      compressor.start();

  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    new DriverControl().start();
    new ConveyorControl().start();
    new HatchGrabberControl().start();
    new VisionAlignment().start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    Scheduler.getInstance().removeAll();
    new DriverControl().start();
    new ConveyorControl().start();
    new HatchGrabberControl().start();
    new VisionAlignment().start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
