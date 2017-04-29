
package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.RobotMap;
import org.usfirst.frc.team68.robot.commands.IntakeDeploy;
import org.usfirst.frc.team68.robot.commands.IntakeReverse;
import org.usfirst.frc.team68.robot.commands.IntakeUp;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
    
	private DoubleSolenoid intakeOrientation;

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
    private Intake() 
    {
    	
    	intakeOrientation = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.INTAKE_DOWN, RobotMap.INTAKE_UP); 
    	intakeMotors = new VictorSP(RobotMap.INTAKE_MOTORS);

    }
    
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new IntakeReverse());    	
    }
    
    public void intakeUp() 
    {
		intakeOrientation.set(Value.kReverse);
    }
    
    public void intakeDown() 
    {
    	intakeOrientation.set(Value.kForward);
    }
        
    public void setIntakeSpeed(double speedForward) 
    {
    	
    	intakeMotors.set(speedForward);
    	
    }
    
    public void setIntakeReverseSpeed(double speedReverse) 
    {
    	
    	intakeMotors.set(speedReverse);
    	
    }
    
    public double getIntakeSpeed()
    {
    	return intakeMotors.get();
    }

}

