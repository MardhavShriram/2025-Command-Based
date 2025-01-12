// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Intake_In;
import frc.robot.commands.Intake_Out;
import frc.robot.commands.PivotSet;
import frc.robot.commands.ShootOut;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain dt = new DriveTrain();
  private final Intake intake = new Intake();
  private final Pivot pivot = new Pivot();
  private final Shooter shooter = new Shooter();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  //Defining the Joysticks
  private final Joystick l_joystick = new Joystick(0);
  private final Joystick r_joystick = new Joystick(1);

  //Defining the Buttons
  //Joystick Button 1
  private final JoystickButton intake_in = new JoystickButton(l_joystick, 1);
  //button 2
  private final JoystickButton intake_out = new JoystickButton(l_joystick, 2);
  //button 3
  private final JoystickButton pivot_1 = new JoystickButton(l_joystick, 3);
  //button 4
  private final JoystickButton pivot_2 = new JoystickButton(l_joystick, 4);
  //button 5
  private final JoystickButton pivot_3 = new JoystickButton(l_joystick, 5);
  //button 6
  private final JoystickButton shoot = new JoystickButton(l_joystick, 6);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Setting the Default Comammand
    dt.setDefaultCommand(new ArcadeDrive(dt, l_joystick, r_joystick));
    // Configure the trigger bindings
    configureBindings();

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
   //Setting the Buttons to the Commands
    intake_in.whileTrue(new Intake_In(intake));
    intake_out.whileTrue(new Intake_Out(intake));
    pivot_1.onTrue(new PivotSet(pivot, Constants.Pivot.angle_1));
    pivot_2.onTrue(new PivotSet(pivot, Constants.Pivot.angle_2));
    pivot_3.onTrue(new PivotSet(pivot, Constants.Pivot.angle_3));
    shoot.whileTrue(new ShootOut(shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
