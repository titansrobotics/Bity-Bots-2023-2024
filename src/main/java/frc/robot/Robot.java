// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
//camera server import
import edu.wpi.first.cameraserver.CameraServer;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private double startTime;

  @Override
  public void robotInit() {
    //Forces the cameras to start. Dunno if we actually need this but I'm adding it
    // just to make sure we get both camera streams up and running.
    CameraServer.startAutomaticCapture("Cam0",0);
    CameraServer.startAutomaticCapture("Cam1",1);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();

    if(time - startTime < 3){
      ArcadeDrive.arcadeDrive();
    } else {
      ArcadeDrive.stopDrive();
    }
    
  }

  @Override
  public void teleopInit() {}


  @Override
  public void teleopPeriodic() {
    ArcadeDrive.arcadeDrive();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
