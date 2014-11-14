/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.subsystems;

import com.fairportfirst.frc2014.RobotMap;
import com.fairportfirst.frc2014.commands.CompressorStartCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian
 */
public class CompressorSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    static CompressorSubsystem instance;
    private Compressor compressor;
    
    public CompressorSubsystem()
    {
        compressor = new Compressor(RobotMap.COMPRESSOR_PRESSURE_SWITCH_CHANNEL, RobotMap.COMPRESSOR_RELAY_CHANNEL);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new CompressorStartCommand());
    }
    
    public void startCompressor()
    {
        compressor.start();
    }
    
    public static CompressorSubsystem getInstance() {
        if (instance == null) {
            instance = new CompressorSubsystem();
        }

        return instance;
    }
}
