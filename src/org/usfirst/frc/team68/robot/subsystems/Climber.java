
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Climber climber;

    
    public static Climber getClimber() {
    	if (climber == null) {
    		climber = new Climber();
    	}
    	return climber;
    }
    
    // Constructor
    private Climber() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

