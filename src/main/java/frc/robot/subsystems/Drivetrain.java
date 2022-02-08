// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private TalonSRX avantDroit;
  private TalonSRX avantGauche;
  private TalonSRX arriereDroit;
  private TalonSRX arriereGauche;

  public Drivetrain() {

    avantDroit = new TalonSRX(Constants.CAN.MOTEUR_AVANT_DROIT);
    avantGauche = new TalonSRX(Constants.CAN.MOTEUR_AVANT_GAUCHE);
    arriereDroit = new TalonSRX(Constants.CAN.MOTEUR_ARRIERE_DROIT);
    arriereGauche = new TalonSRX(Constants.CAN.MOTEUR_ARRIERE_GAUCHE);

    avantDroit.setInverted(false);
    avantGauche.setInverted(false);
    arriereDroit.setInverted(false);
    arriereGauche.setInverted(false);

    avantDroit.follow(arriereDroit);
    avantGauche.follow(arriereGauche);

  }

  public void driveTank(double gauche, double droite){
    arriereDroit.set(ControlMode.PercentOutput, droite);
    arriereGauche.set(ControlMode.PercentOutput, gauche);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
