package com.fairportfirst.frc2014.commands;

import com.fairportfirst.frc2014.OI;
import com.fairportfirst.frc2014.subsystems.BoomSubsystem;
import com.fairportfirst.frc2014.subsystems.CompressorSubsystem;
import com.fairportfirst.frc2014.subsystems.DriveSubsystem;
import com.fairportfirst.frc2014.subsystems.ShooterSubsystem;
import com.fairportfirst.frc2014.subsystems.UltrasonicSubsystem;
import com.fairportfirst.frc2014.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveSubsystem driveSubsystem = DriveSubsystem.getInstance();
    public static BoomSubsystem boomSubsystem = BoomSubsystem.getInstance();
    public static ShooterSubsystem shooterSubsystem = ShooterSubsystem.getInstance();
    public static CompressorSubsystem compressorSubsystem = CompressorSubsystem.getInstance();
    public static UltrasonicSubsystem ultrasonicSubsystem = UltrasonicSubsystem.getInstance();
    public static VisionSubsystem visionSubsystem = VisionSubsystem.getInstance();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveSubsystem);
        SmartDashboard.putData(shooterSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
