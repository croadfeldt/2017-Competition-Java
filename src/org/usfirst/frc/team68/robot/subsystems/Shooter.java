
package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.ShooterFeederReverse;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	// Declare instance variables here
	private CANTalon shooterPrimary;
	private CANTalon shooterFollower;
	private VictorSP shooterFeeder;
	
	private Servo hoodServo;
	
	StringBuilder reportPID = new StringBuilder();
	double targetSpeed = 0;

    
    // Declare Class variables here
    private static Shooter shooter;

    
    public static Shooter getShooter() {
    	if (shooter == null) {
    		shooter = new Shooter();
    	}
    	return shooter;
    }
    
    // Constructor
    private Shooter() {
    	
    	shooterPrimary = new CANTalon(RobotMap.SHOOTER_PRIMARY_MOTOR);
       	shooterPrimary.changeControlMode(TalonControlMode.Speed);
    	this.setShooterSpeed(0);

    	
//    	shooterFollower = new CANTalon(RobotMap.SHOOTER_FOLLOWER_MOTOR);
    	//shooter2.setInverted(true);
//    	shooterFollower.changeControlMode(TalonControlMode.Follower);
//    	shooterFollower.set(shooterPrimary.getDeviceID());
    	
//    	shooterPrimary.enableBrakeMode(false);
//    	shooterFollower.enableBrakeMode(false);
    	
    	shooterPrimary.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	shooterPrimary.reverseSensor(true);
    	shooterPrimary.configNominalOutputVoltage(+0.0f,-0.0f);
    	shooterPrimary.configPeakOutputVoltage(+12.0f, -12.0f);
    	//shooterPrimary.setVoltageRampRate(8);
    	
    	// set closed loop gains for slot 0
    	shooterPrimary.setProfile(RobotMap.SHOOTER_PID_SLOT);
    	shooterPrimary.setF(RobotMap.SHOOTER_PID_F);
    	shooterPrimary.setP(RobotMap.SHOOTER_PID_P);
    	shooterPrimary.setI(RobotMap.SHOOTER_PID_I);
    	shooterPrimary.setD(RobotMap.SHOOTER_PID_D);
    	
    	shooterFeeder = new VictorSP(RobotMap.SHOOTER_FEEDER_MOTOR);
    	shooterFeeder.setInverted(true);
    	
		hoodServo = new Servo(3);


    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ShooterFeederReverse() );
    }
    
    // Create custom methods here
    public void setShooterSpeed(double speed) {
       	
    	targetSpeed = speed;
       	if( shooterPrimary.getControlMode() == TalonControlMode.Speed )
       		System.out.println("Speed");
    	
    	shooterPrimary.set(speed);
    	System.out.println("Set the RPMs to :" + speed);
   	
    }
    
    public void setShooterFeeder(double speed)  {
/*    	if( this.getShooterFeederSpeed() < 0) {
        	shooterFeeder.set(RobotMap.SHOOTER_FEEDER_SPEED_STOP);
        	Timer.delay(.4);
    	} 
*/    	
    	shooterFeeder.set(speed);
    }
    
    public void setShooterFeederReverse(double speed)  {
/*    	if( this.getShooterFeederSpeed() > 0) {
        	shooterFeeder.set(RobotMap.SHOOTER_FEEDER_SPEED_STOP);
        	Timer.delay(.4);
    	}    	
    	double setSpeed = 0;
    	
    	setSpeed = speed > 0 ? RobotMap.SHOOTER_FEEDER_SPEED_REVERSE : 0;
 */
    	
    	shooterFeeder.set(speed);
  
    }
    
    public double getShooterSpeed() {
    	return shooterPrimary.get();
    }
    
    public double getShooterFeederSpeed() {
    	return shooterFeeder.get();
    }
    
    public void setHood(double position) {
    	hoodServo.set(position);
    }
    
    public String getPIDReport() {
    	
    	double motorOutput = shooterPrimary.getOutputVoltage() / shooterPrimary.getBusVoltage();
    	
    	reportPID.setLength(0);
    	
    	reportPID.append("\tout:");
    	reportPID.append(motorOutput);
    	reportPID.append("\tspd:");
    	reportPID.append(shooterPrimary.getSpeed() );
    	reportPID.append("\terr:");
    	reportPID.append(shooterPrimary.getClosedLoopError());
    	reportPID.append("\ttrg:");
    	reportPID.append(targetSpeed);

    	return reportPID.toString();
    }


}

