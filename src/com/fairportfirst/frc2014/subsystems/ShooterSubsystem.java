/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.subsystems;

import com.fairportfirst.frc2014.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Tyler
 */
public class ShooterSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
    private static ShooterSubsystem instance;
    
    Solenoid shooter1Extend;
    Solenoid shooter1Retract;
    Solenoid shooter2Extend;
    Solenoid shooter2Retract;
    Solenoid shooter3Extend;
    Solenoid shooter3Retract;
    Solenoid shooter4Extend;
    Solenoid shooter4Retract;

    public ShooterSubsystem() {
        shooter1Extend = new Solenoid(RobotMap.SHOOTER1_E_ID);
        shooter1Retract = new Solenoid(RobotMap.SHOOTER1_R_ID);
        shooter2Extend = new Solenoid(RobotMap.SHOOTER2_E_ID);
        shooter2Retract = new Solenoid(RobotMap.SHOOTER2_R_ID);
        shooter3Extend = new Solenoid(RobotMap.SHOOTER3_E_ID);
        shooter3Retract = new Solenoid(RobotMap.SHOOTER3_R_ID);
        shooter4Extend = new Solenoid(RobotMap.SHOOTER4_E_ID);
        shooter4Retract = new Solenoid(RobotMap.SHOOTER4_R_ID);
        
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
       
    }
    
    public void extend(){
        shooter1Retract.set(false);
        shooter2Retract.set(false);
        shooter3Retract.set(false);
        shooter4Retract.set(false);
        
        shooter1Extend.set(true);
        shooter2Extend.set(true);
        shooter3Extend.set(true);
        shooter4Extend.set(true);
        
        SmartDashboard.putString("Shooter Status", "Extended");
    }
    
    public void retract(){
        shooter1Extend.set(false);
        shooter2Extend.set(false);
        shooter3Extend.set(false);
        shooter4Extend.set(false);
        
        shooter1Retract.set(true);
        shooter2Retract.set(true);
        shooter3Retract.set(true);
        shooter4Retract.set(true);
        
        SmartDashboard.putString("Shooter Status", "Retracted");
    }
    
    public boolean isExtended(){
        return shooter1Extend.get();
    }
    
    public static ShooterSubsystem getInstance(){
        
        if(instance == null){
            instance = new ShooterSubsystem();
        }
        
        return instance;
    }
    
}