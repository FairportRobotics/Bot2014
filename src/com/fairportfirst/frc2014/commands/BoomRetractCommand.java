/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.commands;

import com.fairportfirst.frc2014.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Tyler
 */
public class BoomRetractCommand extends CommandBase {

    private int inputID;

    public BoomRetractCommand(int id) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(boomSubsystem);
        inputID = id;
    }

    public BoomRetractCommand() {
        requires(boomSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (inputID == -1) {
            boomSubsystem.retractBoom();
        } else {

            boolean rightHanded = SmartDashboard.getBoolean("Operator Right Handed");

            if ((rightHanded && inputID == RobotMap.OPERATOR_BOOM_RETRACT_BUTTON)
                    || (!rightHanded && inputID == RobotMap.OPERATOR_BOOM_RETRACT_BUTTON_2)) {
                SmartDashboard.putString("Boom Status", "Retracted");
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