package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.GearIntake;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gear extends Subsystem 
{
    
  private DoubleSolenoid gearGrabber;
	
    private static Gear gear;
    private VictorSP gearIntakeMotor;
    private boolean isGearDeploying = false;

    public static Gear getgear() 
    {
    	if (gear == null) {
    		gear = new Gear();
    	}
    	return gear;
    }
    
    // Constructor
    private Gear() 
    {
    	gearGrabber = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.GEAR_OUT, RobotMap.GEAR_IN); 
    	gearIntakeMotor = new VictorSP(RobotMap.GEAR_INTAKE_MOTOR);
    	
    	// Start with the Gear Grabber in the UP position
    	this.gearGrabberUp();
    }
    
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new GearIntake());
    }
    
	public void gearGrabberDown() 
    {
		gearGrabber.set(Value.kForward);
    	SmartDashboard.putBoolean("IS GEAR GRABBER DOWN", true);
    }
    
    public void gearGrabberUp() 
    {
    	gearGrabber.set(Value.kReverse);
    	SmartDashboard.putBoolean("IS GEAR GRABBER DOWN", false);
    }
    
    public void setIntakeSpeed(double speed) {
    	gearIntakeMotor.set(speed);
    }
    
    public void setGearIsDeploying ( boolean value) {
    	isGearDeploying = value;
    }
    
    public boolean isGearDeploying() {
    	return isGearDeploying;
    }
    	
}

