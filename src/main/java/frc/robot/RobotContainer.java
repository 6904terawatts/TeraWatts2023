// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunArmJoystick;
import frc.robot.commands.SetArcadeDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElbowSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final ElbowSubsystem m_ElbowSubsystem = new ElbowSubsystem();

  private final static Joystick leftJoystick = new Joystick(Constants.leftJoystickId);
  private final static Joystick rightJoystick = new Joystick(Constants.rightJoystickId);
  // private final static XboxController armController_1 = new XboxController(Constants.ARM_CONTROLLER_1);
  
  public CommandXboxController xboxController = new CommandXboxController(Constants.ARM_CONTROLLER_1);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(new SetArcadeDrive(m_driveTrain, leftJoystick::getY, rightJoystick::getX));
    m_ElbowSubsystem.setDefaultCommand(new RunArmJoystick(m_ElbowSubsystem, xboxController::getLeftY));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
