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
public class BoomExtendCommand extends CommandBase {

    private int inputID = -1;

    /**
     * This constructor is for an operator requesting a boom extend
     *
     * @param id The ID of the button being pressed
     */
    public BoomExtendCommand(int id) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(boomSubsystem);
        inputID = id;
    }

    /**
     * READ: Use the other constructor with a button ID for a user-initiated
     * extend command.
     *
     */
    public BoomExtendCommand() {
        requires(boomSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (inputID == -1) {
            boomSubsystem.extendBoom();
        } else {
            boolean rightHanded = oi.isOperatorRightHanded();

            if ((rightHanded && inputID == RobotMap.OPERATOR_BOOM_EXTEND_BUTTON)
                    || (!rightHanded && inputID == RobotMap.OPERATOR_BOOM_EXTEND_BUTTON_2)) {
                boomSubsystem.extendBoom();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}