// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElbowSubsystem;

public class RunArmJoystick extends CommandBase {
  /** Creates a new RunArmJoystick. */
  private ElbowSubsystem m_arm;
  private DoubleSupplier m_percentOutput;
  public RunArmJoystick(ElbowSubsystem arm, DoubleSupplier PercentOutput) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_arm = arm;
    m_percentOutput = PercentOutput;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    double percentOutput = m_percentOutput.getAsDouble(); 
    if (Math.abs(percentOutput) < Constants.kElavterDeadband) {
      percentOutput = 0;
    }
    m_arm.setPercentOutput(percentOutput * .7);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
