// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.jni.ArmFeedforwardJNI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  /** Creates a new Pivot. */
  //Creating the Pivot Motors
  SparkMax l_pivot;
  SparkMax r_pivot;

  //Creating the Configurations for the Pivot Motors
  SparkMaxConfig l_pivot_config;
  SparkMaxConfig r_pivot_config;

  //Creating the Encoders
  RelativeEncoder l_pivot_encoder;
  RelativeEncoder r_pivot_encoder;

  //Creating the Current Angle
  double current_angle;

  //Creating the PID Output
  double pivot_output;

  //Creating the PID Controller
  PIDController pivot_PID;

  //Creating the Feed Forward
  ArmFeedforward feedfoward;
  
  
  public Pivot() {
    //Defining the PID Controller
    pivot_PID = new PIDController(Constants.Pivot.kp, Constants.Pivot.ki,Constants.Pivot.kd);

    //Defining the Motor IDs
    l_pivot = new SparkMax(Constants.Pivot.leftp_id, MotorType.kBrushless);
    r_pivot = new SparkMax(Constants.Pivot.rightp_id, MotorType.kBrushless);

    //Defining the Encoders
    l_pivot_encoder = l_pivot.getEncoder();
    r_pivot_encoder = r_pivot.getEncoder();

    l_pivot_config = new SparkMaxConfig();
    r_pivot_config = new SparkMaxConfig();


    //IdleMode for the Motors
    r_pivot_config
      .idleMode(IdleMode.kBrake);
    l_pivot_config
      .idleMode(IdleMode.kBrake);

    //Setting the Configuration between Motors
    l_pivot.configure(l_pivot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    r_pivot.configure(r_pivot_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);

    //Feedforward
    feedfoward = new ArmFeedforward(Constants.Pivot.ks, Constants.Pivot.kg, Constants.Pivot.kv, Constants.Pivot.ka);
  }
  public void set_angle(double angle) {
    current_angle = r_pivot_encoder.getPosition();
    pivot_output = pivot_PID.calculate(current_angle, angle);
    feedfoward.calculate(.5,2,3);
    l_pivot.set(MathUtil.clamp(pivot_output, -.75, .75));
    r_pivot.set(MathUtil.clamp(pivot_output, -.75, .75));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
