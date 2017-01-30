
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static DriveTrain driveTrain;

    
    public static DriveTrain getDriveTrain() {
    	if (driveTrain == null) {
    		driveTrain = new DriveTrain();
    	}
    	return driveTrain;
    }
    
    // Constructor
    private DriveTrain() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

