// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {

private final TalonFX[] motors = {
  new TalonFX(Constants.leftBackMotorId),
  new TalonFX(Constants.rightBackMotorId),
  new TalonFX(Constants.leftFrontMotorId),
  new TalonFX(Constants.rightFrontMotorId)
};

 
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
for (TalonFX motor : motors) {
  motor.configFactoryDefault();
  motor.setNeutralMode(NeutralMode.Brake);
}

motors[2].set(ControlMode.Follower , motors[0].getBaseID());
motors[3].set(ControlMode.Follower , motors[1].getBaseID());

// set the motors to rotate the same way

motors[1].setInverted(true);
motors[3].setInverted(true);
  }


public void setPercentOutput(double leftOutput, double rightOutput) {
  motors[0].set(ControlMode.PercentOutput, leftOutput);
  motors[1].set(ControlMode.PercentOutput, rightOutput);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


public static void SetTankDrive(double leftMtr, double rightMtr) {
  leftMtr = RobotContainer.leftJoystick.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
  rightMtr = RobotContainer.rightJoystick.getRawAxis(Constants.DRIVER_CONTROLLER_TURN_AXIS);
}
}
