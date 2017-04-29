
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class USBCamera extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static USBCamera usbCamera;
	private UsbCamera camZero;
	private UsbCamera camOne;


    
    public static USBCamera getCamera() {
    	if (usbCamera == null) {
    		usbCamera = new USBCamera();
    	}
    	return usbCamera;
    }
    
    // Constructor
    private USBCamera() {
    	camZero = CameraServer.getInstance().startAutomaticCapture(0);
        camZero.setResolution(384,216);
        camZero.setFPS(10);

        camOne = CameraServer.getInstance().startAutomaticCapture(1);
        camOne.setResolution(320,240);
        camOne.setFPS(10);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
}

