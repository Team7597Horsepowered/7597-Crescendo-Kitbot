package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj2.command.Command;

public class BrakeCommand extends Command {
    
    public CANSparkMax leftMotor;
    public CANSparkMax rightMotor;

    public BrakeCommand(CANSparkMax left, CANSparkMax right) {
        leftMotor = left;
        rightMotor = right;
        setBrake();
    }
    public void setBrake() {
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void end(boolean interrupted) {
    
  }
}
