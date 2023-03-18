package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase{
    
 private final DoubleSolenoid wristSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
 
 public Wrist() {

 }

 public void setWrist(DoubleSolenoid.Value value) {
    wristSolenoid.set(value);
 }
}
