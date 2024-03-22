// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankSubsystem extends SubsystemBase {
  /** Creates a new TankSubsystem. */
  VictorSPX frontLeft;
  VictorSPX backLeft;
  VictorSPX frontRight;
  VictorSPX backRight;
  
  public TankSubsystem() {
    frontLeft = new VictorSPX(Constants.frontLeftMotorPort);
    frontRight = new VictorSPX(Constants.frontRightMotorPort);
    backLeft = new VictorSPX(Constants.backLeftMotorPort);
    backRight = new VictorSPX(Constants.backRightMotorPort);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
  }

  public void setBoth(double leftSpeed, double rightSpeed){
    frontLeft.set(VictorSPXControlMode.PercentOutput, -leftSpeed);
    frontRight.set(VictorSPXControlMode.PercentOutput, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
