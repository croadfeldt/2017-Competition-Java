
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class USBCameraTest extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static USBCameraTest usbCamera;
	private CameraServer camZero;
	VideoCapture lifeCam;

    
    public static USBCameraTest getCamera() {
    	if (usbCamera == null) {
    		usbCamera = new USBCameraTest();
    	}
    	return usbCamera;
    }
    
    // Constructor
    private USBCameraTest() {
    	lifeCam = new VideoCapture(0);
    	lifeCam.set(Videoio.CAP_PROP_EXPOSURE,-100);
    	lifeCam.set(Videoio.CAP_PROP_BRIGHTNESS, 0);
    	camZero = CameraServer.getInstance();
    	camZero.startAutomaticCapture(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
    
    // Create custom methods here

}

