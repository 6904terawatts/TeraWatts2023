// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElbowSubsystem extends SubsystemBase {
  static CANSparkMax elbowMotor = new CANSparkMax(3, MotorType.kBrushed);
  
  public ElbowSubsystem() {
    elbowMotor.restoreFactoryDefaults();
    
    // elbowMotor = new CANSparkMax(1, MotorType.kBrushless);
    // armMotor = new CANSparkMax(2, MotorType.kBrushless);
    // elbowMotor.setInverted(true);
    // elbowMotor.follow(armMotor);
    
    
  }

  public void foldupElbow() {
    elbowMotor.set(-0.1);
  
  }
 
  public void stopElbow() {
    elbowMotor.set(0);
   
  }

  public static void start() {
  }

public void setPercentOutput(double y) {
  elbowMotor.set(y);
}
@Override
  public void periodic() {

  }
}
