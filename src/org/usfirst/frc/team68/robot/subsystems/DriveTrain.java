package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	private double driveOrientation;
	
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
		driveOrientation = -1;  // note that pushing forward on the joystick returns negative values
	
		driveShifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.DRIVETRAIN_SHIFT_LOW, RobotMap.DRIVETRAIN_SHIFT_HIGH);
		this.setShifterLow();
	
	}
	
	
	public void initDefaultCommand() {
	   	setDefaultCommand(new DriveWithXboxJoysticks());
	}
	
    public double getDriveOrientation() {
    	return driveOrientation;
    }
    
    public void setShifterHigh() {
    	driveShifter.set(Value.kForward);
    }
    
    public void setShifterLow() {
    	driveShifter.set(Value.kReverse);
    }
    
    public void setDriveOrientation() {
    	// Reverse the current drive orientation
    	driveOrientation = driveOrientation * -1;
    	// update the dashboard to reflect the current drive orientation
    	SmartDashboard.putNumber("Drive Orientation: ", driveOrientation);
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
    	drive.tankDrive(leftSpeed*driveOrientation, rightSpeed*driveOrientation, true);    	
    }
}
