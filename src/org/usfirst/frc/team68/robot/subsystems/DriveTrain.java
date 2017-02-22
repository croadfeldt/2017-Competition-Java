package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.DriveWithXboxJoysticks;

import com.ctre.CANTalon; 


public class DriveTrain extends Subsystem {
	
	private CANTalon driveTrain_FL;
	private CANTalon driveTrain_FR;
	private CANTalon driveTrain_RL;
	private CANTalon driveTrain_RR;
	private RobotDrive drive;
	private DoubleSolenoid driveShifter;
	public static DriveTrain driveTrain;

	
	public static DriveTrain getDriveTrain () {
		if (driveTrain == null) {
			driveTrain = new DriveTrain();
		}
		return driveTrain;
	}
	
	private DriveTrain() {
		

		driveTrain_RL = new CANTalon(RobotMap.DRIVETRAIN_RL);
		driveTrain_RR = new CANTalon(RobotMap.DRIVETRAIN_RR);
		
		driveTrain_FL = new CANTalon(RobotMap.DRIVE_LEFT_FRONT);
		driveTrain_FL.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveTrain_FL.set(driveTrain_RL.getDeviceID());
    	
		driveTrain_FR = new CANTalon(RobotMap.DRIVE_RIGHT_FRONT);
		driveTrain_FR.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveTrain_FR.set(driveTrain_RR.getDeviceID());
		
		
		drive = new RobotDrive(driveTrain_RL, driveTrain_RR);
		drive.setSafetyEnabled(true);

	
	
	driveShifter = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_LOW, RobotMap.DRIVETRAIN_SHIFT_HIGH);
	this.setShifterLow();
	
	
	}
	
	
	public void initDefaultCommand() {
	   	setDefaultCommand(new DriveWithXboxJoysticks());
	}
	
	   public void setShifterHigh() {
	    	driveShifter.set(Value.kForward);
	
	    }
	    
	    public void setShifterLow() {
	    	driveShifter.set(Value.kReverse);
	    	
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

	    	drive.tankDrive(leftSpeed*-1, rightSpeed*-1, true);
    }
}
