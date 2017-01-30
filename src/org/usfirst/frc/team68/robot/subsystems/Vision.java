
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Vision vision;

    
    public static Vision getvision() {
    	if (vision == null) {
    		vision = new Vision();
    	}
    	return vision;
    }
    
    // Constructor
    private Vision() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

