/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.commands.autonomous;

import com.fairportfirst.frc2014.RobotMap;
import com.fairportfirst.frc2014.commands.CommandBase;
import com.fairportfirst.frc2014.commands.ExtendShooterCommand;
import com.fairportfirst.frc2014.commands.ShootCommand;

/**
 *
 * @author Brian
 */
public class FireHotGoalCommand extends CommandBase {

    private boolean fired = false;

    public FireHotGoalCommand() {
        requires(visionSubsystem);
        requires(ultrasonicSubsystem);
        requires(shooterSubsystem);
        
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        fired = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if ((visionSubsystem.getNumberOfHorizontalTargets() == 1 && !fired) || (timeSinceInitialized() > 7 && !fired)) {
            shooterSubsystem.extend();
            fired = true;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            shooterSubsystem.retract();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fired;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
