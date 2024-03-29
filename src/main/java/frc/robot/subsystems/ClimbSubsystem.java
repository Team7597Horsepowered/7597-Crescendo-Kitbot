// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  public CANSparkMax leftClimb;
  public CANSparkMax rightClimb;
  
  public ClimbSubsystem() {
    leftClimb = new CANSparkMax(Constants.leftClimb, MotorType.kBrushless);
    rightClimb = new CANSparkMax(Constants.rightClimb, MotorType.kBrushless);
    leftClimb.setInverted(true);
  }

  public void extend(){
    leftClimb.set(Constants.climbSpeed);
    rightClimb.set(Constants.climbSpeed);
    
  }

  public void setRetract(){
    leftClimb.set(-Constants.climbSpeed);
    rightClimb.set(-Constants.climbSpeed);
  }

  public void retractLeft() {
    leftClimb.set(-Constants.climbSpeed);
  }

  public void retractRight() {
    rightClimb.set(-Constants.climbSpeed);
  }

  public void setBrake() {
    leftClimb.setIdleMode(IdleMode.kBrake);
    rightClimb.setIdleMode(IdleMode.kBrake);
  }

  public void end() {
    setBrake();
    leftClimb.set(0);
    rightClimb.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
