
package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.IntakeReverse;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
	// Declare instance variables here
	private VictorSP intakeMotors;

    
    // Declare Class variables here
    private static Intake intake;

    
    public static Intake getIntake() {
    	if (intake == null) {
    		intake = new Intake();
    	}
    	return intake;
    }
    
    // Constructor
    private Intake() {
    	
    	intakeMotors = new VictorSP(RobotMap.INTAKE_MOTORS);

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new IntakeReverse() );
    }
    
    // Create custom methods here
    
    public void setIntakeSpeed(double speedForward) {
    	// check to see if the intake is current spinning in reverse
    	// and stop it before spinning it forward
/*    	if( this.getIntakeSpeed() < 0) {
        	intakeMotors.set(RobotMap.INTAKE_SPEED_STOP);
        	Timer.delay(.4);
    	} 
*/	
    	intakeMotors.set(speedForward);
    	
    }
    
    public void setIntakeReverseSpeed(double speedReverse) {
    	// check to see if the intake is current spinning in reverse
    	// and stop it before spinning it forward
/*    	if( this.getIntakeSpeed() > 0) {
        	intakeMotors.set(RobotMap.INTAKE_SPEED_STOP);
        	Timer.delay(.4);
    	} 
*/    	
    	intakeMotors.set(speedReverse);
    	
    }
    
    public double getIntakeSpeed(){
    	return intakeMotors.get();
    }

}

