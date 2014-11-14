package com.fairportfirst.frc2014;

import com.fairportfirst.frc2014.commands.AxisTestCommand;
import com.fairportfirst.frc2014.commands.BoomExtendCommand;
import com.fairportfirst.frc2014.commands.BoomRetractCommand;
import com.fairportfirst.frc2014.commands.BoomSpinCommand;
import com.fairportfirst.frc2014.commands.BoomSpinReverseCommand;
import com.fairportfirst.frc2014.commands.ShootCommand;
import com.fairportfirst.frc2014.commands.ToggleHighSpeedCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    private Joystick leftJoy;
    private Joystick rightJoy;
    private Joystick gamePad;
    private Button boomExtendButton;
    private Button boomRetractButton;
    private Button boomExtendButton2;
    private Button boomRetractButton2;
    private Button boomSpinButton;
    private Button boomSpinButton2;
    private Button boomSpinReverseButton;
    private Button boomSpinReverseButton2;
    private Button shootButton;
    private Button shootButton2;
    private Button shiftCommand;
    private Button shiftCommand2;
    private Button turnOnLightsButton;
    private Button turnOffLightsButton;
    
    public Button axisTestButton;

    public OI() {

        leftJoy = new Joystick(RobotMap.DRIVER_LEFT_JOY_ID);
        rightJoy = new Joystick(RobotMap.DRIVER_RIGHT_JOY_ID);
        gamePad = new Joystick(RobotMap.OPERATOR_CONTROLLER_ID);
        gamePad.getRawAxis(5);

        //TODO: FIX BUTTON IDs
        shootButton = new JoystickButton(leftJoy, RobotMap.DRIVER_SHOOTER_BUTTON);
        shootButton2 = new JoystickButton(gamePad, RobotMap.OPERATOR_SHOOTER_BUTTON);
        shootButton.whenPressed(new ShootCommand());
        shootButton2.whenPressed(new ShootCommand());

        SmartDashboard.putBoolean("Operator Right Handed", true);
        
        boomExtendButton = new JoystickButton(gamePad, RobotMap.OPERATOR_BOOM_EXTEND_BUTTON);
        //boomExtendButton.whenPressed(new BoomExtendCommand(RobotMap.OPERATOR_BOOM_EXTEND_BUTTON));
        boomRetractButton = new JoystickButton(gamePad, RobotMap.OPERATOR_BOOM_RETRACT_BUTTON);
        //boomRetractButton.whenPressed(new BoomRetractCommand(RobotMap.OPERATOR_BOOM_RETRACT_BUTTON));
        boomExtendButton2 = new JoystickButton(gamePad, RobotMap.OPERATOR_BOOM_EXTEND_BUTTON_2);
        //boomExtendButton2.whenPressed(new BoomExtendCommand(RobotMap.OPERATOR_BOOM_EXTEND_BUTTON_2));
        boomRetractButton2 = new JoystickButton(gamePad, RobotMap.OPERATOR_BOOM_RETRACT_BUTTON_2);
        //boomRetractButton2.whenPressed(new BoomRetractCommand(RobotMap.OPERATOR_BOOM_RETRACT_BUTTON_2));

        boomSpinButton = new JoystickButton(gamePad, RobotMap.OPERATOR_FEEDER_FORWARD_BUTTON);
        boomSpinButton2 = new JoystickButton(gamePad, RobotMap.OPERATOR_FEEDER_FORWARD_BUTTON_2);
        boomSpinButton.whileHeld(new BoomSpinCommand());
        boomSpinButton2.whileHeld(new BoomSpinCommand());
        boomSpinReverseButton = new JoystickButton(gamePad, RobotMap.OPERATOR_FEEDER_REVERSE_BUTTON);
        boomSpinReverseButton2 = new JoystickButton(gamePad, RobotMap.OPERATOR_FEEDER_REVERSE_BUTTON_2);
        boomSpinReverseButton.whileHeld(new BoomSpinReverseCommand());
        boomSpinReverseButton2.whileHeld(new BoomSpinReverseCommand());
        shiftCommand = new JoystickButton(leftJoy, RobotMap.SHIFT_COMMAND_BUTTON_LEFT);
        shiftCommand2 = new JoystickButton(rightJoy, RobotMap.SHIFT_COMMAND_BUTTON_RIGHT);
        shiftCommand.whenPressed(new ToggleHighSpeedCommand());
        shiftCommand2.whenPressed(new ToggleHighSpeedCommand());
        
        axisTestButton = new JoystickButton(gamePad, 9);
        axisTestButton.whileHeld(new AxisTestCommand());

        /*
         turnOnLightsButton = new JoystickButton(rightJoy, 11);
         turnOnLightsButton.whenPressed(new EnableLightsCommand());
         turnOffLightsButton = new JoystickButton(leftJoy, 11);
         turnOffLightsButton.whenPressed(new DisableLightCommand());*/
        
        SmartDashboard.putNumber("Alert Distance Max Feet", 3.4);
        SmartDashboard.putNumber("Alert Distance Min Feet", 3.0);
    }
    
    public boolean isOperatorRightHanded(){
        return SmartDashboard.getBoolean("Operator Right Handed");
    }

    public double getLeftStickY() {
        return leftJoy.getY();
    }

    public double getRightStickY() {
        return rightJoy.getY();
    }

    public double getYAxis() {
        return leftJoy.getY();
    }

    public double getXAxis() {
        return leftJoy.getX();
    }

    public double getZAxis() {
        return leftJoy.getZ();
    }

    public boolean isShootButtonDown() {
        return shootButton.get();
    }

    public boolean isShootButton2Down() {
        return shootButton2.get();
    }

    public boolean isBoomSpinButtonDown() {
        return boomSpinButton.get() || boomSpinButton2.get();
    }

    public boolean isBoomSpinReverseButtonDown() {
        return boomSpinReverseButton.get() || boomSpinReverseButton2.get();
    }
    
    public double getVertAxisRawValue() {
        return gamePad.getRawAxis(6);
    }
    
    public double getHorizontalAxisRawValue() {
        return gamePad.getRawAxis(5);
    }
    
    public boolean isBoomExtendButtonDown() {
        return boomExtendButton.get();
    }
    
    public boolean isBoomRetractButtonDown(){
        return boomRetractButton.get();
    }
    
    public double getMaxAlertDistance() {
        return SmartDashboard.getNumber("Alert Distance Max Feet");
    }
    
    public double getMinAlertDistance() {
        return SmartDashboard.getNumber("Alert Distance Min Feet");
    }
//    public boolean isEnableLightsButtonDown() {
//        return turnOnLightsButton.get();
//    }
}
