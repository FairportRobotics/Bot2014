package com.fairportfirst.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int FRONT_LEFT_JAGUAR_ID = 14;
    public static final int FRONT_RIGHT_JAGUAR_ID = 17;
    public static final int BACK_LEFT_JAGUAR_ID = 13;
    public static final int BACK_RIGHT_JAGUAR_ID = 12;
    
    public static final int DRIVE_SHIFTER_RELAY = 2;
    
    public static final int BOOM_RELAY_ID = 1;
    public static final int BOOM_JAGUAR_ID = 18;
    
    public static final int SHOOTER1_E_ID = 1;
    public static final int SHOOTER1_R_ID = 2;
    public static final int SHOOTER2_E_ID = 3;
    public static final int SHOOTER2_R_ID = 4;
    public static final int SHOOTER3_E_ID = 5;
    public static final int SHOOTER3_R_ID = 6;
    public static final int SHOOTER4_E_ID = 7;
    public static final int SHOOTER4_R_ID = 8;
    
    public static final int COMPRESSOR_RELAY_CHANNEL = 3;
    public static final int COMPRESSOR_PRESSURE_SWITCH_CHANNEL = 2;
    
    public static final int LIGHT_RELAY_CHANNEL = 4;
    public static final int ULTRASONIC_CHANNEL = 2;
    
    //Vision Subsystem
    public static final String CAMERA_IP = "10.5.78.11";
    
    
    //Button binds
    
    //Operator binds
    public static final int OPERATOR_CONTROLLER_ID = 3;
    public static final int OPERATOR_SHOOTER_BUTTON = 10;
    public static final int OPERATOR_BOOM_EXTEND_BUTTON = 4;
    public static final int OPERATOR_BOOM_RETRACT_BUTTON = 2;
    public static final int OPERATOR_BOOM_EXTEND_BUTTON_2 = 12;
    public static final int OPERATOR_BOOM_RETRACT_BUTTON_2 = 14;


    public static final int OPERATOR_FEEDER_FORWARD_BUTTON = 6;
    public static final int OPERATOR_FEEDER_FORWARD_BUTTON_2 = 8;
    public static final int OPERATOR_FEEDER_REVERSE_BUTTON = 5;
    public static final int OPERATOR_FEEDER_REVERSE_BUTTON_2 = 7;
    
    //Driver binds
    public static final int DRIVER_LEFT_JOY_ID = 1;
    public static final int DRIVER_RIGHT_JOY_ID =2;
    //public static final int SOLENOID_ID = 14;
    public static final double SHOOTER_RETRACT_DELAY = 0.5;
    
    public static final int SHIFT_COMMAND_BUTTON_RIGHT = 6;
    public static final int SHIFT_COMMAND_BUTTON_LEFT = 5;
    public static final int DRIVER_SHOOTER_BUTTON = 1;
}
