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
public final class IntakeCAN_IDs {
  public static final int LeftIntakeMotor = 5;
  public static final int RightIntakeMotor = 6;
}
public final class Intake_Speed {
public static final double intake_out_speed = -0.5;
public static final double intake_in_speed = 0.5;
}
public final class Pivot_IDs {
  public static final int l_pivot_ID = 7;
  public static final int r_pivot_ID = 8;
}
public final class pivot_speed {
  public static final double pivot_up_speed = 0.5;
  public static final double pivot_down_speed = -0.5;
}
public final class Shooter_IDs {
  public static final int l_shooter_ID = 9;
  public static final int r_shooter_ID = 10;
}
  public final class shooter_speed {
  public static final double shooter_speed = 0.75;
  }
}