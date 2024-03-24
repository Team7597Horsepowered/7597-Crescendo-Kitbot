// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
  /** Creates a new ShootCommand. */
  ShooterSubsystem m_ShooterSubsystem;
  public ShootCommand(ShooterSubsystem m_ShooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_ShooterSubsystem = m_ShooterSubsystem;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ShooterSubsystem.setTopSpeed(1.0);
    if(RobotContainer.m_operatorController.getHID().getRightTriggerAxis() > Constants.joystickDeadband){
        System.out.println("test'");
        m_ShooterSubsystem.setBottomSpeed(1.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ShooterSubsystem.setTopSpeed(0);
    m_ShooterSubsystem.setBottomSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
