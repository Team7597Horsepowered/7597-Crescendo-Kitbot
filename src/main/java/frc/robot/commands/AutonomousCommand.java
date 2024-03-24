package frc.robot.commands;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
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
  private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

  public AutonomousCommand() {
    //execute();
  }

      /*private void scheduleDisable(long timeToWait) {
      executor.scheduleWithFixedDelay(AutonomousCommand::disable, 0, timeToWait, TimeUnit.SECONDS);
    }

    private void scheduleDrive(long timeToWait) {
      executor.scheduleWithFixedDelay(AutonomousCommand::drive, timeToWait, timeToWait, TimeUnit.SECONDS);
    }

    private static void drive() {
      TankSubsystem system = new TankSubsystem();
      system.setBoth(10, 10);
    }

    @Override
    public void execute() {
        m_IntakeCommand.execute();
        scheduleDrive(2);
        m_IntakeCommand.end(true);
        scheduleDisable(10);
    }

     public static void disable() {
      TankSubsystem system = new TankSubsystem();
      system.setBoth(0, 0);
    }

    @Override
    public void end(boolean interrupted) {
      m_IntakeCommand.end(true);
        disable();
    } */
}
