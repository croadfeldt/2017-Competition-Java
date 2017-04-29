
package org.usfirst.frc.team68.robot.subsystems;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfInt;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

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
		new Thread(() -> {
			startCamZero();
		}).start();
		
		new Thread(() -> {
			startCamOne();
		}).start();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new Command() );
	}
	
	public void startCamZero() {
		camZero = CameraServer.getInstance().startAutomaticCapture(0);
		camZero.setResolution(384,216);
		camZero.setFPS(10);

		CvSink cvSink = CameraServer.getInstance().getVideo(camZero);
		CvSource outputStream = CameraServer.getInstance().putVideo("CamZero", 384, 216);

		Mat source = new Mat();
		Mat output = new Mat();
		MatOfByte buf;
		MatOfInt  params40 = new MatOfInt(Imgcodecs.IMWRITE_JPEG_QUALITY, 40);
	    MatOfInt  params90 = new MatOfInt(Imgcodecs.IMWRITE_JPEG_QUALITY, 90);

		while(!Thread.interrupted()) {
			cvSink.grabFrame(source);
			Imgcodecs.imencode(".jpg", source, buf, params40);
			outputStream.putFrame(buf);
		}
	}
	
	public void startCamOne() {
		camZero = CameraServer.getInstance().startAutomaticCapture(0);
		camZero.setResolution(320,240);
		camZero.setFPS(10);

		CvSink cvSink = CameraServer.getInstance().getVideo(camZero);
		CvSource outputStream = CameraServer.getInstance().putVideo("CamZero", 320, 240);

		Mat source = new Mat();
		Mat output = new Mat();
		MatOfByte buf;
		MatOfInt  params40 = new MatOfInt(Imgcodecs.IMWRITE_JPEG_QUALITY, 40);
	    MatOfInt  params90 = new MatOfInt(Imgcodecs.IMWRITE_JPEG_QUALITY, 90);

		while(!Thread.interrupted()) {
			cvSink.grabFrame(source);
			Imgcodecs.imencode(".jpg", source, buf, params40);
			outputStream.putFrame(buf);
		}
	}

}

