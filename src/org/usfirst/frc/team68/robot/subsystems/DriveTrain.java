package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveWithXboxJoysticks;

import com.ctre.CANTalon; 


public class DriveTrain extends Subsystem {
	
	private CANTalon leftFront;
	private CANTalon rightFront;
	private CANTalon leftRear;
	private CANTalon rightRear;
	private RobotDrive drive;
	private DoubleSolenoid driveShifter;
	private boolean reverseDrive;
	private Relay gearLights;
	private Relay intakeLights;
	
	public static DriveTrain driveTrain;

	
	public static DriveTrain getDriveTrain () {
		if (driveTrain == null) {
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}
	
	private DriveTrain() {

		leftRear = new CANTalon(RobotMap.DRIVETRAIN_LEFT_REAR);
		rightRear = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_REAR);
		
		leftFront = new CANTalon(RobotMap.DRIVETRAIN_LEFT_FRONT);
		leftFront.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftFront.set(leftRear.getDeviceID());
    	
		rightFront = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_FRONT);
		rightFront.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightFront.set(rightRear.getDeviceID());
		
		
		drive = new RobotDrive(leftRear, rightRear);
		drive.setSafetyEnabled(true);

		// Initialize the drive orientation.  We start with the orientation of
		// robot front = intake. 
		reverseDrive = true;  // note that pushing forward on the joystick returns negative values
	
		driveShifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.DRIVETRAIN_SHIFT_LOW, RobotMap.DRIVETRAIN_SHIFT_HIGH);
		this.setShifterLow();
		
		gearLights = new Relay(0);
		intakeLights = new Relay(1);
	
	}
	
	
	public void initDefaultCommand() {
	   	setDefaultCommand(new DriveWithXboxJoysticks());
	}
	
    public boolean getDriveOrientation() {
    	return reverseDrive;
    }
    
    public void setShifterHigh() {
    	driveShifter.set(Value.kForward);
    }
    
    public void setShifterLow() {
    	driveShifter.set(Value.kReverse);
    }
    
    public void setDriveOrientation() {
    	// Reverse the current drive orientation
    	reverseDrive = !reverseDrive;
    	// update the dashboard to reflect the current drive orientation
    	SmartDashboard.putBoolean("Drive Orientation: ", reverseDrive);
    }
    
    public void zeroEncoders(){
    	leftRear.setPosition(0);
    	rightRear.setPosition(0);
    }

    
    public void shift() {
    	if(this.getShifter() == Value.kForward){
    	  	this.setShifterLow();
    	} else {
    		this.setShifterHigh();
    	}
    }
    
    public DoubleSolenoid.Value getShifter() {
    	return driveShifter.get();
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
    	if(reverseDrive){
    		drive.tankDrive(-1*rightSpeed, -1*leftSpeed, true);
    	} else {
    		drive.tankDrive(leftSpeed, rightSpeed, true);
    	}
    }
    
    public void setLights() {
    	if(reverseDrive) {
    		intakeLights.set(Relay.Value.kForward);
    		gearLights.set(Relay.Value.kReverse);
    	} else {
    		gearLights.set(Relay.Value.kForward);
    		intakeLights.set(Relay.Value.kReverse);
    	}
    }
}
