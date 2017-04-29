
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutonRedRightGear extends CommandGroup 
{    	
 	
	public AutonRedRightGear() 
    { 
//    	addSequential(new DriveMM(0,2.5,0,240,0,240)); //Turn using right side only
//     	addSequential(new DriveMM(-7.048,7.027,240,240,240,240)); 
//     	addSequential(new WaitCommand(2));
     	addSequential(new DriveMM(-7.048,7.027,240,240,240,240)); 
    	addSequential(new WaitCommand(1));
     	addSequential(new DriveMM(-1.353,1.363,240,240,240,240)); 
    } 
    
}
