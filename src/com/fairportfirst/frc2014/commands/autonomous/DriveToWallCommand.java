/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.commands.autonomous;

import com.fairportfirst.frc2014.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brian
 */
public class DriveToWallCommand extends CommandBase {
    
    public static final double driveSpeed = 0.8; //0 - 1
    public static final double driveTime = 1.25; //seconds
    
    public DriveToWallCommand() {
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveSubsystem.setShifterLowSpeed();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveSubsystem.driveTank(-driveSpeed, -driveSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timeSinceInitialized() >= driveTime);
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSubsystem.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
