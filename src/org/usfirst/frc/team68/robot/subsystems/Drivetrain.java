
package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveWithXboxJoysticks;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private CANTalon leftFront;
	private CANTalon leftRear;
	private CANTalon rightFront;
	private CANTalon rightRear;
	private RobotDrive drive;
	//private DoubleSolenoid driveShifter;
	private boolean gear = false;
	private boolean mid = false;
	private static boolean useSquaredInputs = true;
	private int absolutePositionLeftRear;
	private int absolutePositionRightRear;
	private boolean isPercentVbus = true;

	private static Drivetrain drivetrain;
	
	public static Drivetrain getDrive () {
		if (drivetrain == null) {
			drivetrain = new Drivetrain();
		}
		return drivetrain;
	}
    // Constructor
	private Drivetrain() {
		
		// Instantiate Drive Motors
		leftRear = new CANTalon(RobotMap.DRIVE_LEFT_REAR);
		rightRear = new CANTalon(RobotMap.DRIVE_RIGHT_REAR);
		
		leftFront = new CANTalon(RobotMap.DRIVE_LEFT_FRONT);
		leftFront.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftFront.set(leftRear.getDeviceID());
    	
		rightFront = new CANTalon(RobotMap.DRIVE_RIGHT_FRONT);
		rightFront.changeControlMode(CANTalon.TalonControlMode.Follower);
    	rightFront.set(rightRear.getDeviceID());
    	
    	leftFront.enableBrakeMode(false);
    	leftRear.enableBrakeMode(false);
    	rightFront.enableBrakeMode(false);
    	leftFront.enableBrakeMode(false);


		drive = new RobotDrive(leftRear, rightRear);
		

		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		
		drive.setSafetyEnabled(true);
	
		//	driveShifter = new DoubleSolenoid(RobotMap.DRIVE_SHIFTER_PCM_A, RobotMap.DRIVE_SHIFTER_PCM_B);
		//		this.setShifterLow();
	}

    public void initDefaultCommand() {
       
    	setDefaultCommand(new DriveWithXboxJoysticks());
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
    	
    	leftSpeed*=RobotMap.DRIVE_MULT;
   		rightSpeed*=RobotMap.DRIVE_MULT;
    	
    	drive.tankDrive(leftSpeed, rightSpeed, useSquaredInputs);
    }
    
    public void setPower(double power){
    	leftRear.set(power*-1);
    	rightRear.set(power);
    }
    public void setPowers(double powerL, double powerR){
    	leftRear.set(powerL*-1);
    	rightRear.set(powerR);
    }
    
    /*public void setShifterHigh() {
    	driveShifter.set(Value.kForward);
    	gear = true;
    	mid = true;
    }
    
    public void setShifterLow() {
    	driveShifter.set(Value.kReverse);
    	gear = false;
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
    
    }*/
}
