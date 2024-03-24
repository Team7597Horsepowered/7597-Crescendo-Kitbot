// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  VictorSPX leftClimb;
  VictorSPX rightClimb;
  public ClimbSubsystem() {
    leftClimb = new VictorSPX(Constants.leftClimb);
    rightClimb = new VictorSPX(Constants.rightClimb);

    VictorSPXConfiguration climbConfiguration = new VictorSPXConfiguration();

    leftClimb.configAllSettings(climbConfiguration);
    rightClimb.configAllSettings(climbConfiguration);

    leftClimb.setInverted(true);
  }

  public void extend(){
    leftClimb.setInverted(false);
    rightClimb.setInverted(true);
    leftClimb.set(ControlMode.PercentOutput, Constants.climbSpeed);
    rightClimb.set(ControlMode.PercentOutput, Constants.climbSpeed);
  }

  public void setRetract(){
    leftClimb.setInverted(true);
    rightClimb.setInverted(false);
    leftClimb.set(ControlMode.PercentOutput, Constants.climbSpeed);
    rightClimb.set(ControlMode.PercentOutput, Constants.climbSpeed);

  }

  public void setRightRetract() {
    rightClimb.setInverted(false);
    rightClimb.set(ControlMode.PercentOutput, Constants.climbSpeed);
  }

  public void stop() {
    leftClimb.set(ControlMode.PercentOutput, 0.0);
    rightClimb.set(ControlMode.PercentOutput, 0.0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
