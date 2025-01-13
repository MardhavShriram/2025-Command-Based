// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  //Defining the Shooter Motors
  SparkMax l_shooter;
  SparkMax r_shooter;

  //Defining the Configurations for the Shooter Motors
  SparkMaxConfig l_shooter_config;
  SparkMaxConfig r_shooter_config;
  
  public Shooter() {
    //Defining the Motor IDs
    l_shooter = new SparkMax(Constants.Shooter.l_shooter_id, SparkMax.MotorType.kBrushless);
    r_shooter = new SparkMax(Constants.Shooter.r_shooter_id, SparkMax.MotorType.kBrushless);

    //Defining the Configurations
    l_shooter_config = new SparkMaxConfig();
    r_shooter_config = new SparkMaxConfig();

    //IdleMode for the Motors
    l_shooter_config
    .idleMode(IdleMode.kBrake);
    r_shooter_config
    .idleMode(IdleMode.kBrake);

    //Setting the Configuration between Motors
    l_shooter.configure(l_shooter_config,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    r_shooter.configure(r_shooter_config,ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  public void shoot(double shooter_speed) {
    r_shooter.set(shooter_speed);
    l_shooter.set(shooter_speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
