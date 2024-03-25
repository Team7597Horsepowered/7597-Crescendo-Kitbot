package frc.robot.swerve.parser.json;

import static frc.robot.swerve.telemetry.SwerveDriveTelemetry.canIdWarning;

import frc.robot.swerve.encoders.CANCoderSwerve;
import frc.robot.swerve.encoders.SparkMaxAnalogEncoderSwerve;
import frc.robot.swerve.encoders.SparkMaxEncoderSwerve;
import frc.robot.swerve.encoders.SwerveAbsoluteEncoder;
import frc.robot.swerve.imu.ADIS16448Swerve;
import frc.robot.swerve.imu.ADIS16470Swerve;
import frc.robot.swerve.imu.ADXRS450Swerve;
import frc.robot.swerve.imu.AnalogGyroSwerve;
import frc.robot.swerve.imu.Pigeon2Swerve;
import frc.robot.swerve.imu.PigeonSwerve;
import frc.robot.swerve.imu.SwerveIMU;
import frc.robot.swerve.motors.SparkMaxSwerve;
import frc.robot.swerve.motors.SwerveMotor;

/**
 * Device JSON parsed class. Used to access the JSON data.
 */
public class DeviceJson
{

  /**
   * The device type, e.g. pigeon/pigeon2/sparkmax/talonfx/navx
   */
  public String type;
  /**
   * The CAN ID or pin ID of the device.
   */
  public int    id;
  /**
   * The CAN bus name which the device resides on if using CAN.
   */
  public String canbus = "";

  /**
   * Create a {@link SwerveAbsoluteEncoder} from the current configuration.
   *
   * @param motor {@link SwerveMotor} of which attached encoders will be created from, only used when the type is
   *              "attached" or "canandencoder".
   * @return {@link SwerveAbsoluteEncoder} given.
   */
  public SwerveAbsoluteEncoder createEncoder(SwerveMotor motor)
  {
    if (id > 40)
    {
      canIdWarning.set(true);
    }
    switch (type)
    {
      case "none":
        return null;
      case "integrated":
      case "attached":
        return new SparkMaxEncoderSwerve(motor, 1);
      case "sparkmax_analog":
        return new SparkMaxAnalogEncoderSwerve(motor);
      case "canandcoder":
        return new SparkMaxEncoderSwerve(motor, 360);
      case "ctre_mag":
      case "rev_hex":
      case "throughbore":
      case "am_mag":
      case "thrifty":
      case "ma3":
      case "cancoder":
        return new CANCoderSwerve(id, canbus != null ? canbus : "");
      default:
        throw new RuntimeException(type + " is not a recognized absolute encoder type.");
    }
  }

  /**
   * Create a {@link SwerveIMU} from the given configuration.
   *
   * @return {@link SwerveIMU} given.
   */
  public SwerveIMU createIMU()
  {
    if (id > 40)
    {
      canIdWarning.set(true);
    }
    switch (type)
    {
      case "adis16448":
        return new ADIS16448Swerve();
      case "adis16470":
        return new ADIS16470Swerve();
      case "adxrs450":
        return new ADXRS450Swerve();
      case "analog":
        return new AnalogGyroSwerve(id);
      case "navx":
      case "pigeon":
        return new PigeonSwerve(id);
      case "pigeon2":
        return new Pigeon2Swerve(id, canbus != null ? canbus : "");
      default:
        throw new RuntimeException(type + " is not a recognized imu/gyroscope type.");
    }
  }

  /**
   * Create a {@link SwerveMotor} from the given configuration.
   *
   * @param isDriveMotor If the motor being generated is a drive motor.
   * @return {@link SwerveMotor} given.
   */
  public SwerveMotor createMotor(boolean isDriveMotor)
  {
    if (id > 40)
    {
      canIdWarning.set(true);
    }
    switch (type)
    {
      case "neo":
      case "sparkmax":
        return new SparkMaxSwerve(id, isDriveMotor);
      case "falcon":
      default:
        throw new RuntimeException(type + " is not a recognized motor type.");
    }
  }
}
