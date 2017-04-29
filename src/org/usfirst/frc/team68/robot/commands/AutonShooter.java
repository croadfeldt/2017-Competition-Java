
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutonShooter extends CommandGroup 
{    	

	public AutonShooter() 
    { 
		//addSequential(new DriveShiftHigh()); // Start in low gear
     	addSequential(new GearGrabberUp());  // Lift Gear Grabber
     	addSequential(new AutonDrive(1.3, -0.93, -0.9));  //Drive forward 
     	addSequential(new AutonDrive(1.0, 0.7, -0.7));  //Turn left 
     	
    } 
    
}
