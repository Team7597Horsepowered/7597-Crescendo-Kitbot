// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int frontLeftMotorPort = 1;
  public static final int backLeftMotorPort = 2;
  public static final int frontRightMotorPort = 4;
  public static final int backRightMotorPort = 3;

  public static final int topShooterMotor = 5;
  public static final int bottomShooterMotor = 6;

  public static final int leftClimb = 7;
  public static final int rightClimb = 8;

  public static final int driverPort = 0;
  public static final int operatorPort = 1;
  public static final double joystickDeadband = 0.08;

  public static final double intakeSpeed = -0.5;
  public static final double shootSpeed = 1;

  public static double climbSpeed = 0.35;

  public static final double ROBOT_MASS = 75 * 0.453592; // 32lbs * kg per pound

  public static final double maxSpeed = 4;
}
