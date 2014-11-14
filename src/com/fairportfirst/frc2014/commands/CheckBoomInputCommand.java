/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brian
 */
public class CheckBoomInputCommand extends CommandBase {
    
    public CheckBoomInputCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        requires(boomSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if (oi.isOperatorRightHanded())
        {
            if (oi.isBoomExtendButtonDown())
            {
                boomSubsystem.extendBoom();
            }
            else if (oi.isBoomRetractButtonDown())
            {
                boomSubsystem.retractBoom();
            }
        }
        else
        {
        if (oi.getVertAxisRawValue() < -0.75)
        {
            boomSubsystem.extendBoom();
        }
        else if (oi.getVertAxisRawValue() > 0.75)
        {
            boomSubsystem.retractBoom();
        }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
