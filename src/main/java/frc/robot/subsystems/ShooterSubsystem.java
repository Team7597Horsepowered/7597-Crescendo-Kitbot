// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.jni.CANSparkMaxJNI;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterCommand. */
  CANSparkMax topMotor;
  CANSparkMax bottomMotor;
  public ShooterSubsystem() {
    topMotor = new CANSparkMax(Constants.topShooterMotor, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(Constants.bottomShooterMotor, MotorType.kBrushless);

    topMotor.setInverted(true);
    bottomMotor.setInverted(true);
  }

  public void setIntakeSpeed(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  public void setTopSpeed(double speed){
    topMotor.set(speed);
  }

  public void setBottomSpeed(double speed){
    bottomMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
