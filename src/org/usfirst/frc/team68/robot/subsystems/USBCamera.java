
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class USBCamera extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static USBCamera usbCamera;
	private CameraServer camZero;

    
    public static USBCamera getCamera() {
    	if (usbCamera == null) {
    		usbCamera = new USBCamera();
    	}
    	return usbCamera;
    }
    
    // Constructor
    private USBCamera() {
    	camZero = CameraServer.getInstance();
    	camZero.startAutomaticCapture(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

