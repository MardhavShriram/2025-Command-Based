// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  //Defiing the Motors
  SparkMax l_intake;
  SparkMax r_intake;

  //Defining the Configurations per Motor
  SparkMaxConfig l_intake_configure;
  SparkMaxConfig r_intake_configure;

  public Intake() {
  //Setting the Motor Ids
  l_intake = new SparkMax(Constants.Intake.LeftIntake_id, MotorType.kBrushless);
  r_intake = new SparkMax(Constants.Intake.RightIntake_id, MotorType.kBrushless);

  l_intake_configure = new SparkMaxConfig();
  r_intake_configure = new SparkMaxConfig();

  //Set the Idle Mode
  r_intake_configure
  .idleMode(IdleMode.kBrake);
  l_intake_configure
  .idleMode(IdleMode.kBrake);

  //Set the Configurations
  l_intake.configure(l_intake_configure, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  r_intake.configure(r_intake_configure, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  public void intake_move (double intake_speed) {
    l_intake.set(intake_speed);
    r_intake.set(intake_speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
 
}
