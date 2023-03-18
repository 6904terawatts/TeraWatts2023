// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

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

// motors[2].set(ControlMode.Follower , motors[0].getBaseID());
// motors[3].set(ControlMode.Follower , motors[1].getBaseID());

// set the motors to rotate the same way

motors[1].setInverted(true);
motors[3].setInverted(true);

motors[2].follow(motors[0]);
motors[3].follow(motors[1]);

  }

public void setArcadeDrive(double throttle, double turn) {
  double leftOutput = throttle + turn;
  double rightOutput = throttle - turn;
  
  
  if (Math.abs(leftOutput) < Constants.kArcadeDeadBand) {
    leftOutput = 0;
  }
  if (Math.abs(rightOutput) < Constants.kArcadeDeadBand) {
    rightOutput = 0;
  }
    double squaredRightOutput = rightOutput * rightOutput * Math.signum(rightOutput); 
    double squaredLeftOutput = leftOutput * leftOutput * Math.signum(leftOutput); 
  
    setPercentOutput(squaredLeftOutput, squaredRightOutput);
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
}
