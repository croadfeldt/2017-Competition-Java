
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonTest extends CommandGroup 
{    	

	public AutonTest() 
    { 
     	addSequential(new DriveMM(-5,5,240,240,120,120)); 
    } 
    
}
