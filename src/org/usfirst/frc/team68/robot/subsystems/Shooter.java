
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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private double targetSpeed = 0;
	private double feederSpeed = 0;

    
    // Declare Class variables here
    private static Shooter shooter;

    
    public static Shooter getShooter() {
    	if (shooter == null) {
    		shooter = new Shooter();
    	}
    	return shooter;
    }
    
    // Constructor
    public Shooter() {
    	
    	shooterPrimary = new CANTalon(RobotMap.SHOOTER_PRIMARY_MOTOR);
       	shooterPrimary.changeControlMode(TalonControlMode.Speed);
    	this.setShooterSpeed(0);

    	shooterFollower = new CANTalon(RobotMap.SHOOTER_FOLLOWER_MOTOR);
    	//shooter2.setInverted(true);
    	shooterFollower.changeControlMode(TalonControlMode.Follower);
    	shooterFollower.set(shooterPrimary.getDeviceID());
    	
    	shooterPrimary.enableBrakeMode(false);
    	shooterFollower.enableBrakeMode(false);
    	
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
    	
		hoodServo = new Servo(RobotMap.SHOOTER_HOOD_SERVO);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ShooterFeederReverse());
    }
    
    // Create custom methods here
    public void setShooterSpeed(double speed) {
    	// set an instance variable to the incoming speed value.
    	// It is referenced by the getPIDReport() method in this class
    	//targetSpeed = speed;
    	
    	// Ensure that we are in speed mode.  We need to do this
    	// since we currently stop the shooter using percentVbus
       	shooterPrimary.changeControlMode(TalonControlMode.Speed);

       	// Publish the target speed to the dashboard
       	targetSpeed = speed;
    	SmartDashboard.putNumber("Shooter Target RPM Value: ", targetSpeed);

    	shooterPrimary.set(speed);
    }
    
    public void setShooterFeeder(double speed)  {
    	speed = (this.getShooterSpeed() >= targetSpeed*.99) ? speed : 0;
    	shooterFeeder.set(speed);
    }
    
   public void setShooterFeederValue(double speed)  {	
    	feederSpeed = speed;	
    }
   
   public double getShooterFeederValue() {
	   return feederSpeed;
   }
    
    public void setShooterFeederReverse(double speed)  {
    	// We needed a separate method for variable control
    	// to clear the shooter feeder should it become jammed.
    	// The default command in this class will run
    	// constantly looking for input from the Right Trigger
    	// on the xbox manipulate controller
    	
    	shooterFeeder.set(speed);
  
    }
    
    public void setShooterPID(double F, double P, double I, double D){
    	shooterPrimary.setF(F);
    	shooterPrimary.setP(P);
    	shooterPrimary.setI(I);
    	shooterPrimary.setD(D);
    	this.setShooterSpeed(SmartDashboard.getNumber("Shooter Target RPM Value: ", targetSpeed));
    }
    
    public void stopShooter() {
       	shooterPrimary.changeControlMode(TalonControlMode.PercentVbus);
    	shooterPrimary.set(0);
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
    
    public double getHood() {
    	return hoodServo.get();
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

