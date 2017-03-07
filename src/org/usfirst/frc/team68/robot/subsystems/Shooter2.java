
package org.usfirst.frc.team68.robot.subsystems;

import org.usfirst.frc.team68.robot.commands.ShootWithXboxJoysticks;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter2 extends Subsystem {
    
	// Declare instance variables here
	CANTalon _talon;
    
    // Declare Class variables here
    private static Shooter2 shooter2;

    
    public static Shooter2 getShooter2() {
    	if (shooter2 == null) {
    		shooter2 = new Shooter2();
    	}
    	return shooter2;
    }
    
    // Constructor
    private Shooter2() {
    	_talon = new CANTalon(5);	
    	
    	_talon.changeControlMode(TalonControlMode.Speed);
        _talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        _talon.reverseSensor(false);
        _talon.enableBrakeMode(true);
        
        /* set the peak and nominal outputs, 12V means full */
        _talon.configNominalOutputVoltage(+0.0f, -0.0f);
        _talon.configPeakOutputVoltage(+12.0f, -12.0f);
        /* set closed loop gains in slot0 */
        _talon.setProfile(0);
        _talon.setF(0.1097);
        _talon.setP(0.010);
        _talon.setI(-0.1); 
        _talon.setD(0.0);

    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ShootWithXboxJoysticks() );
    }
    
    // Create custom methods here
    public void setShooter2Speed (double x) {
    	_talon.set(x);
    }

}

