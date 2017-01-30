
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Gear gear;

    
    public static Gear getgear() {
    	if (gear == null) {
    		gear = new Gear();
    	}
    	return gear;
    }
    
    // Constructor
    private Gear() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

