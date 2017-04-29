
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutonDriveLine extends CommandGroup 
{    	

	public AutonDriveLine() 
    { 
     	addSequential(new AutonDrive(7.0, -0.62, -0.6));  //Drive forward 
    } 
    
}
