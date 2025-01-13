// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

public final class DriveCAN_IDs {
  public static final int FrontLeftMotor = 1;
  public static final int BackLeftMotor = 2;
  public static final int FrontRightMotor = 3;
  public static final int BackRightMotor = 4;
}
public final class Intake{
  public static final int LeftIntake_id = 5;
  public static final int RightIntake_id = 6;

public static final double intake_out_speed = -0.5;
public static final double intake_in_speed = 0.5;
}
public final class Pivot {
  public static final int leftp_id = 7;
  public static final int rightp_id = 8;

  public static final int angle_1 = 0;
  public static final int angle_2 = 30;
  public static final int angle_3 = 50;

  public static final double kp = 1;
  public static final double ki = 0;
  public static final double kd = 0;
}

public final class Shooter {
  public static final int l_shooter_id = 9;
  public static final int r_shooter_id = 10;

  public static final double shooter_speed = 0.75;
}
}