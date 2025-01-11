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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  /** Creates a new Pivot. */
  //Defining the Pivot Motors
  SparkMax l_pivot;
  SparkMax r_pivot;

  //Defining the Configurations for the Pivot Motors
  SparkMaxConfig l_pivot_config;
  SparkMaxConfig r_pivot_config;

  public Pivot() {
    //Defining the Motor IDs
    SparkMax l_pivot = new SparkMax(Constants.Pivot_IDs.l_pivot_ID, MotorType.kBrushless);
    SparkMax r_pivot = new SparkMax(Constants.Pivot_IDs.r_pivot_ID, MotorType.kBrushless);

    //Setting the Configuration between Motors
    l_pivot.configure(l_pivot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    r_pivot.configure(r_pivot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);

    //IdleMode for the Motors
    r_pivot_config.idleMode(IdleMode.kBrake);
    l_pivot_config.idleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void pivot_move(double pivot_speed){
    r_pivot.set(pivot_speed);
    l_pivot.set(pivot_speed);
  }
}
