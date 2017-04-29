package org.usfirst.frc.team68.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team68.robot.commands.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	// Declare instance variables here

	// Driver's Xbox Controller
	private XboxController xboxDrive;
	private Button xboxDriveA;
	private Button xboxDriveB;
	private Button xboxDriveX;
	private Button xboxDriveY;
	private Button xboxDriveRB;
	private Button xboxDriveLB;
	private Button xboxDriveBack;
	private Button xboxDriveStart;
	
	// Manipulators Xbox Controller
	private XboxController xboxManipulate;
	private Button xboxManipulateA;
	private Button xboxManipulateB;
	private Button xboxManipulateX;
	private Button xboxManipulateY;
	private Button xboxManipulateRB;
	private Button xboxManipulateLB;
	private Button xboxManipulateBack;
	private Button xboxManipulateStart;
	
	// Declare class variables here
	private static OI oi;
	
	// Provide a class method using the Singleton
	// design pattern which guarantees only one 
	// intstance of this class will get created.
	public static OI getOI(){
		if (oi == null) {
			oi = new OI();
		}
		return oi;	
	}
	
	// Constructor
	private OI() {
		
		// Drivers Xbox Controller Bindings
		xboxDrive = new XboxController(RobotMap.XBOX_DRIVE);	
		xboxManipulate = new XboxController(RobotMap.XBOX_MANIPULATE);
		
		xboxDriveX = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_X);
		xboxDriveX.whenPressed(new ClimberLock());

		xboxDriveY = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_Y);
		xboxDriveY.whenPressed(new ClimberUnlock());
		
		xboxDriveLB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_LB);
		xboxDriveLB.whenPressed(new DriveShiftLow());
		
		xboxDriveRB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_RB);
		xboxDriveRB.whenPressed(new DriveShiftHigh());
		
		xboxDriveStart = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BS);
		xboxDriveStart.whenPressed(new DriveReverseOrientation());
		
		xboxDriveA = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_A);
		xboxDriveA.whenPressed(new GearDeploy());
		
		xboxDriveB = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_B);
		xboxDriveB.whenPressed(new GearDeployComplete());
		
//		xboxDriveBack = new JoystickButton(xboxDrive, RobotMap.XBOX_DRIVE_BB);
//		xboxDriveBack.whenPressed(new DriveMMStraight());
		
		
		// Manipulators Xbox Controller Bindings
		xboxManipulateX = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_X);
		xboxManipulateX.whenPressed(new ShooterStart(RobotMap.SHOOTER_SPEED_SHORT, RobotMap.SHOOTER_HOOD_SHORT, RobotMap.SHOOTER_FEEDER_SPEED_SHORT));

		xboxManipulateA = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_A);
		xboxManipulateA.whenPressed(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));
		
		xboxManipulateB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_B);
		xboxManipulateB.whenPressed(new ShooterStart(RobotMap.SHOOTER_SPEED_LONG, RobotMap.SHOOTER_HOOD_LONG, RobotMap.SHOOTER_FEEDER_SPEED_LONG));
		
		xboxManipulateY = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_Y);
		xboxManipulateY.whenPressed(new ShooterStop());
		
		xboxManipulateLB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_LB);
		xboxManipulateLB.whileHeld(new IntakeForward());
		
		xboxManipulateRB = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_RB);
		xboxManipulateRB.whileHeld(new ShooterFeederForward());
		
		xboxManipulateStart = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_BS);
		xboxManipulateStart.whenPressed(new GearGrabberDown());
		
		xboxManipulateBack = new JoystickButton(xboxManipulate, RobotMap.XBOX_MANIPULATE_BB);
		xboxManipulateBack.whenPressed(new GearGrabberUp());
		
	}
	
	// Custom user defined methods should go here
	
	// Drivetrain Tank Drive Left 
	public double getLeftXboxJoystickValue() {
		double leftAxis;
		leftAxis = xboxDrive.getY(Hand.kLeft);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}

	// Drivetrain Tank Drive Right
	public double getRightXboxJoystickValue() {
		double rightAxis;
		rightAxis = xboxDrive.getY(Hand.kRight);
		// Allow for up to 10% of joystick noise
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}
	
	// Intake Reverse ( Out )
	public double getXboxManipulateLT() {
		double leftAxis;
		leftAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_LT);
		// Allow for up to 10% of joystick noise
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}
	
	// Shooter Feeder Reverse ( Out )
	public double getXboxManipulateRT() {
		double rightAxis;
		rightAxis = xboxManipulate.getRawAxis(RobotMap.XBOX_MANIPULATE_RT);
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}
	
	// Gear Intake
	public double getLeftXboxManipulatorJoystick() {
		double leftAxis;
		leftAxis = xboxManipulate.getY(Hand.kLeft);
		leftAxis = (Math.abs(leftAxis) < 0.1) ? 0 : leftAxis;
    	return leftAxis;
	}
	
	// Gear Intake
	public double getRightXboxManipulatorJoystick() {
		double rightAxis;
		rightAxis = xboxManipulate.getY(Hand.kRight);
		rightAxis = (Math.abs(rightAxis) < 0.1) ? 0 : rightAxis;
    	return rightAxis;
	}

	
	// Gear Grabber Up/Down
	public double getLeftXboxManipulatorPOV() {
		double povAngle;
		povAngle = xboxManipulate.getPOV();
		
    	return povAngle;
	}

	// Intake Up/Down
		public double getLeftXboxDrivePOV() 
		{
			double povAngle;
			povAngle = xboxDrive.getPOV();
			
	    	return povAngle;
		}

}
