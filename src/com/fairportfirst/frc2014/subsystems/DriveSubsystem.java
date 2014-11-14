package com.fairportfirst.frc2014.subsystems;

import com.fairportfirst.frc2014.DriveMode;
import com.fairportfirst.frc2014.RobotMap;
import com.fairportfirst.frc2014.RobotTemplate;
import com.fairportfirst.frc2014.commands.TankDriveCommand;
import com.fairportfirst.frc2014.commands.ThreeAxisDriveCommand;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private static DriveSubsystem instance;
    private CANJaguar frontLeft;
    private CANJaguar frontRight;
    private CANJaguar backLeft;
    private CANJaguar backRight;
    
    
    private Relay shifter;

    public DriveSubsystem() {

        shifter = new Relay(RobotMap.DRIVE_SHIFTER_RELAY);
        
        shifter.setDirection(Relay.Direction.kForward);
        
        try {
            frontLeft = new CANJaguar(RobotMap.FRONT_LEFT_JAGUAR_ID);
            frontRight = new CANJaguar(RobotMap.FRONT_RIGHT_JAGUAR_ID);          
            backLeft = new CANJaguar(RobotMap.BACK_LEFT_JAGUAR_ID);
            backRight = new CANJaguar(RobotMap.BACK_RIGHT_JAGUAR_ID);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    /* Drives the robot while using two joysticks.
       Used in TankDriveCommand. 
    */ 
    public void driveTank(double left, double right) {
        try {
            frontLeft.setX(-left);
            frontRight.setX(right);

            backLeft.setX(-left);
            backRight.setX(right);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }
    
    /* Turns the relay on.
       Testing needed to see how it controls the shifter.
     */
    public void setShifterHighSpeed()
    {
        shifter.set(Relay.Value.kOn);
    }
    
    /* Turns the relay off.
     * Testing needed to see how it controls the shifter.
     */
    public void setShifterLowSpeed()
    {
        shifter.set(Relay.Value.kOff);
    }
    
    public boolean isHighSpeed(){
        return shifter.get().value == Relay.Value.kOn.value;
    }
    
    /* Drives the robot while using one joystick.
       Used in ThreeAxisCommand.
       * 
       * Unused, using Tank Drive instead
    */
    public void driveThreeAxis(double frontBack, double leftRight) {
        try {
            frontLeft.setX(frontBack);
            frontRight.setX(-frontBack);

            backLeft.setX(frontBack);
            backRight.setX(-frontBack);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }
    
    /* Spins the robot while the robot is in three axis mode.
       Used in ThreeAxisDriveCommand.
       * 
       * Unused, using Tank Drive instead
    */
    public void spin(double speed) {
        try {
            frontLeft.setX(speed);
            frontRight.setX(-speed);

            backLeft.setX(-speed);
            backRight.setX(speed);
        } catch (CANTimeoutException e) {
            e.printStackTrace();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

        if (RobotTemplate.getDriveMode() == DriveMode.tankDrive) {
            setDefaultCommand(new TankDriveCommand());
        } else {
            setDefaultCommand(new ThreeAxisDriveCommand());
        }

    }

    //@return instance of DriveSubsystem
    public static DriveSubsystem getInstance() {
        if (instance == null) {
            instance = new DriveSubsystem();
        }

        return instance;
    }
}
