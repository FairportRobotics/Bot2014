/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.subsystems;

import com.fairportfirst.frc2014.RobotMap;
import com.fairportfirst.frc2014.commands.ReadUltrasonicCommand;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author chris
 */
public class UltrasonicSubsystem extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    AnalogChannel ultraSonic;
    Relay light;
    static UltrasonicSubsystem instance;
    
    public UltrasonicSubsystem()
    {
        ultraSonic = new AnalogChannel(RobotMap.ULTRASONIC_CHANNEL);
        light = new Relay(RobotMap.LIGHT_RELAY_CHANNEL);
        light.setDirection(Relay.Direction.kForward);
        light.set(Relay.Value.kOff);
    }
    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ReadUltrasonicCommand());
    }
    
    
    //takes the voltage of the ultrasonic and converts it to inches
    public double getDistanceInches()
    {
        return ultraSonic.getVoltage() / 0.000977 * 0.0393701;
    }
    
    //takes the voltage of the ultrasonic and converts it to feet
    public double getDistaceFeet()
    {
        return getDistanceInches()/12;
    }
    
    //turns the cathode lights on
    public void setLightsOn()
    {
        light.set(Relay.Value.kOn);
    }
    
    //turns the cathode lights off
    public void setLightsOff()
    {
        light.set(Relay.Value.kOff);
    }
    
    //returns an instance of a method
    public static UltrasonicSubsystem getInstance()
    {
        if(instance==null)
        {
            instance = new UltrasonicSubsystem();
        }
        return instance;
    }
}
