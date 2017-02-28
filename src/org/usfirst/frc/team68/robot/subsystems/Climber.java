
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



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
 
    	climberLatch = new DoubleSolenoid(RobotMap.CLIMBER_LATCH_OPEN, RobotMap.CLIMBER_LATCH_CLOSE);
    	
    	
    }
    
    public void initDefaultCommand() {
   
    }

	
	 public void climberLock() {
	    	climberLatch.set(Value.kForward);
	    }
	    
	    public void climberUnlock() {
	    	climberLatch.set(Value.kReverse);
	    }
	}
