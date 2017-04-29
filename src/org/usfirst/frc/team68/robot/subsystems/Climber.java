
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Climber extends Subsystem {
    
	private DoubleSolenoid climberLatch;
	private static Climber climber;
 
    
    public static Climber getClimber() {
    	if (climber == null) {
    		climber = new Climber();
    	}
    	return climber;
    }
    
   
    private Climber() {
 
    	climberLatch = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.CLIMBER_LOCK, RobotMap.CLIMBER_UNLOCK);
    	this.climberUnlock();
    	
    }
    
    public void initDefaultCommand() {
   
    }

	
	 public void climberLock() {
	    climberLatch.set(Value.kForward);
    	SmartDashboard.putBoolean("IS CLIMBER LOCKED", true);
	 }
	    
	 public void climberUnlock() {
    	climberLatch.set(Value.kReverse);
    	SmartDashboard.putBoolean("IS CLIMBER LOCKED", false);

	 }
	 
}
