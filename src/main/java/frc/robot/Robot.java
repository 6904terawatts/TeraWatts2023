// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveForward;
import frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  private final XboxController xbox = new XboxController(Constants.ARM_CONTROLLER_1);
  private DriveTrain m_drivetrain;
  private final Timer autoTimer = new Timer();
  /**
   * This function is run when the robot is first starte          d up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    CameraServer.startAutomaticCapture();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    autonomousPeriodic();
    autoTimer.reset();
    autoTimer.start();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  Compressor comp = new
 
  // we are working towards this, we sent a message to Adrian.
  // We called a new compresor, this will release air for the robot to use. 
  Compressor(0, PneumaticsModuleType.CTREPCM);
 
 
 
  // We created a Doble Solenoid component and command it with releasing air and pushing in air. 
 
 
//  private final DoubleSolenoid Air1 =
//  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

//  private final DoubleSolenoid Air2 =
//  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
 
 
 private static final int kDoubleSolenoidForward = 2;
 private static final int kDoubleSolenoidReverse = 3;
 
  /*  This detects the air presure inside the robot and will stop the compresor from making more air.
   * This will start the compressor when the psi presure reachs 90 psi 
   
    // DoubleSolenoid corresponds to a double solenoid.
   private final DoubleSolenoid m_doubleSolenoid =
       new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  */
  boolean pressureSwitch = comp.getPressureSwitchValue();
  /* Getting the current value of the presure switch */
  double current = comp.getCurrent();
 // This was checked and looks ok
 private Object m_stick; 

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    
  // if  (xbox.getAButtonPressed()) {

  //   Air1.set(DoubleSolenoid.Value.kForward);

  // } else if (xbox.getBButtonPressed()) {

  //   Air1.set(DoubleSolenoid.Value.kReverse);
  // }

  // if  (xbox.getXButtonPressed()) {

  //   Air2.set(DoubleSolenoid.Value.kForward);

  // } else if (xbox.getYButtonPressed()) {

  //   Air2.set(DoubleSolenoid.Value.kReverse);
  // }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
