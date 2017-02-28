package org.usfirst.frc.team68.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Gear extends Subsystem 
{
    
  private DoubleSolenoid gearPouch;
	
    private static Gear gear;

    public static Gear getgear() 
    {
    	if (gear == null) {
    		gear = new Gear();
    	}
    	return gear;
    }
    
    private Gear() 
    {
    	gearPouch = new DoubleSolenoid(RobotMap.GEAR_OUT, RobotMap.GEAR_IN); 
    	
    }
    
    public void initDefaultCommand() 
    {

    }
    public boolean isGearPouchOut() 
    {
    	if(gearPouch.get() == Value.kForward) 
    	{
    		return true;
    	} else 
    	{
    		return false;
    	}
    }
    public void gearPouchOut() 
    {
    	gearPouch.set(Value.kForward);
    }
    public void gearPouchIn() 
    {
    	gearPouch.set(Value.kReverse);
    }
    public void reverseCurrentGearPouchPosition() 
    {
    	if(gearPouch.get() == Value.kForward) 
    	{
    		this.gearPouchOut(); 
    	} 
    	
    	else 
    	{
    		this.gearPouchIn();
    	}
    }
}

