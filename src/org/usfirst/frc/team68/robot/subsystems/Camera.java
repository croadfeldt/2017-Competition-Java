
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Camera camera;

    
    public static Camera getcamera() {
    	if (camera == null) {
    		camera = new Camera();
    	}
    	return camera;
    }
    
    // Constructor
    private Camera() {

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

