package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class RightArmRetract extends Command{
    
    /** Creates a new RightArmRetract. */
  ClimbSubsystem m_ClimbSubsystem;
  public RightArmRetract(ClimbSubsystem m_ClimbSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_ClimbSubsystem = m_ClimbSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ClimbSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ClimbSubsystem.setRightRetract();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ClimbSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }




}
