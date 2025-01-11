// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  // Defining the Motors
  SparkMax back_right;
  SparkMax front_right; 
  SparkMax back_left;
  SparkMax front_left;

  // Defining the Configurations per Motor
  SparkMaxConfig back_right_config;
  SparkMaxConfig front_right_config;
  SparkMaxConfig back_left_config;
  SparkMaxConfig front_left_config;

  //Defining the Positional Variables
  double rx;
  double ly;

  /** Creates a new ArcadeDrive. */
  public DriveTrain() {


    //Setting the Motor Ids and Motor Type
    back_right = new SparkMax(Constants.DriveCAN_IDs.BackRightMotor, MotorType.kBrushless);
    front_right = new SparkMax(Constants.DriveCAN_IDs.FrontRightMotor, MotorType.kBrushless);
    back_left = new SparkMax(Constants.DriveCAN_IDs.BackLeftMotor, MotorType.kBrushless);
    front_left = new SparkMax(Constants.DriveCAN_IDs.FrontLeftMotor, MotorType.kBrushless);

     //Connecting the Configurations to the Motor
     front_right.configure(front_right_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
     front_left.configure(front_left_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
     back_left.configure(back_left_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
     back_right.configure(back_right_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    //Setting the Motor Configurations for the Idle Mode
    back_right_config.idleMode(IdleMode.kBrake);
    front_right_config.idleMode(IdleMode.kBrake);
    back_left_config.idleMode(IdleMode.kBrake);
    front_left_config.idleMode(IdleMode.kBrake);

    //Setting the Back Motors to Follow the Front Motors
    back_left_config.follow(front_left);
    back_right_config.follow(front_right);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
}

  public void arcadeDrive(Joystick l_joystick, Joystick r_joystick) {
  
  //Getting the Joystick Values
  rx = r_joystick.getX();
  ly = l_joystick.getY();

  //Setting the Motor Speeds
  front_right.set(ly-rx);
  front_left.set(ly+rx);
}
}
