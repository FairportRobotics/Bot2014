/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.frc2014;

/**
 *
 * @author Tyler
 */
public class DriveMode {
    
    int value;
    
    public static DriveMode tankDrive = new DriveMode(1);
    public static DriveMode axisDrive = new DriveMode(2);
    
    public DriveMode(int num){
        value = num;
    }
    
    public int getValue(){
        return value;
    }
    
}
