// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbExtender;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TankCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TankSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private static final TankSubsystem m_tankSubsystem = new TankSubsystem();
  private final ClimbSubsystem m_ClimbSubsystem = new ClimbSubsystem();

  private final IntakeCommand m_IntakeCommand = new IntakeCommand(m_ShooterSubsystem);
  private final ShootCommand m_ShootCommand = new ShootCommand(m_ShooterSubsystem);
  private final TankCommand m_tankCommand = new TankCommand(m_tankSubsystem);
  private final ClimbExtender m_ClimbExtender = new ClimbExtender(m_ClimbSubsystem);
  private final ClimbDown m_ClimbDown = new ClimbDown(m_ClimbSubsystem);
  private final AutonomousCommand command = new AutonomousCommand();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final CommandXboxController m_driverController =
      new CommandXboxController(Constants.driverPort);

  public static final CommandXboxController m_operatorController =
      new CommandXboxController(Constants.operatorPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    m_tankSubsystem.setDefaultCommand(m_tankCommand);
    
    configureBindings();
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_operatorController.a().whileTrue(m_ShootCommand);
    m_operatorController.leftTrigger().whileTrue(m_IntakeCommand);

    m_operatorController.leftBumper().whileTrue(m_ClimbExtender);
    m_operatorController.rightBumper().whileTrue(m_ClimbDown);

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  public static TankSubsystem getTankSubsystem() {
    return m_tankSubsystem;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return command;
  }
}
