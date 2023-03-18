package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase{
    
 private final DoubleSolenoid clawSolenoid =
 new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

 public Claw() {

 }

 public void setClaw(DoubleSolenoid.Value value) {
    clawSolenoid.set(value);
 }
}
