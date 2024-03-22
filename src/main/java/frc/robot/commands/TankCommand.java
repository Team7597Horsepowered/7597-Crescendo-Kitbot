// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.TankSubsystem;

public class TankCommand extends Command {
  /** Creates a new TankCommand. */
  TankSubsystem m_TankSubsystem;
  public TankCommand(TankSubsystem m_tankSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_tankSubsystem);
    this.m_TankSubsystem = m_tankSubsystem;
  }


  @Override
  public void execute(){
    double leftJoystick = RobotContainer.m_driverController.getLeftY();
    double rightJoystick = RobotContainer.m_driverController.getRightY();
    leftJoystick = Math.abs(leftJoystick) < Constants.joystickDeadband ? 0 : leftJoystick;
    rightJoystick = Math.abs(rightJoystick) < Constants.joystickDeadband ? 0 : rightJoystick;
    m_TankSubsystem.setBoth(leftJoystick, rightJoystick);
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TankSubsystem.setBoth(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
