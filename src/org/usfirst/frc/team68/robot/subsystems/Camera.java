
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Camera extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static Camera camera;
	private CameraServer cameraUSB0;

    
    public static Camera getCamera() {
    	if (camera == null) {
    		camera = new Camera();
    	}
    	return camera;
    }
    
    // Constructor
    private Camera() {
    	cameraUSB0.startAutomaticCapture(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

