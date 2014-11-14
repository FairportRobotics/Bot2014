/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014.subsystems;

import com.fairportfirst.frc2014.RobotMap;
import com.fairportfirst.frc2014.commands.CheckBoomInputCommand;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brian
 */
public class BoomSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    static BoomSubsystem instance;
    private Relay boom;
    private CANJaguar ballIntake;
    public static final int SPIN_SPEED = 1;
    public static final int SPIN_REVERSE_SPEED = -1;

    public BoomSubsystem() {
        
        boom = new Relay(RobotMap.BOOM_RELAY_ID);
        boom.setDirection(Relay.Direction.kForward);
        boom.set(Relay.Value.kOff);
        
        try {
            ballIntake = new CANJaguar(RobotMap.BOOM_JAGUAR_ID);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        setDefaultCommand(new CheckBoomInputCommand());
    }

    /**
     * Checks whether or not the boom is extended
     *
     * @return boom status
     */
    public boolean isBoomExtended() {
        return boom.get() == Relay.Value.kOn;
    }

    /**
     * Extends the boom so that balls can be rolled into the robot
     *
     */
    public void extendBoom() {
        boom.set(Relay.Value.kOn);
        SmartDashboard.putString("Boom Status", "Extended");
    }

    /**
     * Retracts the boom into the robot
     *
     */
    public void retractBoom() {
        boom.set(Relay.Value.kOff);
        SmartDashboard.putString("Boom Status", "Retracted");
    }

    /**
     * Spins the Jaguar on the boom, to draw balls into the robot.
     *
     */
    public void spin() {
        try {
            if (ballIntake.getX() < SPIN_SPEED) {
                ballIntake.setX(SPIN_SPEED);
            }
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * Spins the Jaguar on the boom in reverse, to eject balls from the robot.
     *
     */
    public void spinReverse() {
        try {
            if (ballIntake.getX() > SPIN_REVERSE_SPEED) {
                ballIntake.setX(SPIN_REVERSE_SPEED);
            }
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    public double getSpinSpeed()
    {
        try {
            return ballIntake.getX();
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
        
        return Integer.MAX_VALUE;
    }
    
    /**
     * Stops the Jaguar on the boom
     *
     */
    public void stopSpin() {
        try {
            ballIntake.setX(0);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    public static BoomSubsystem getInstance() {
        if (instance == null) {
            instance = new BoomSubsystem();
        }

        return instance;
    }
}
