package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TankSubsystem;

public class AutonomousCommand extends Command {
    private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final TankSubsystem m_tankSubsystem = new TankSubsystem();
  private final ClimbSubsystem m_ClimbSubsystem = new ClimbSubsystem();

  private final IntakeCommand m_IntakeCommand = new IntakeCommand(m_ShooterSubsystem);
  private final ShootCommand m_ShootCommand = new ShootCommand(m_ShooterSubsystem);
  private final TankCommand m_tankCommand = new TankCommand(m_tankSubsystem);
  private final ClimbExtender m_ClimbExtender = new ClimbExtender(m_ClimbSubsystem);
  private final ClimbDown m_ClimbDown = new ClimbDown(m_ClimbSubsystem);

    public AutonomousCommand() {
        
    }

    @Override
    public void execute() {
        m_IntakeCommand.execute();
        m_tankSubsystem.setBoth(-10, -10);
    }

    @Override
    public void end(boolean interrupted) {
        m_IntakeCommand.end(true);
        m_tankSubsystem.setBoth(0, 0);
    }
}
