
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonCenterGearPos extends CommandGroup 
{    	

	public AutonCenterGearPos() 
    { 
     	addSequential(new DrivePosition(6.0, 6.0, -0.93, -0.90)); //Drive forward
    	addSequential(new WaitCommand(2));
//     	addSequential(new AutonDrive(1.0, 0.0, 0.0)); //Stop
    	addSequential(new GearDeploy());  //Deploy the gear
//     	addSequential(new AutonDrive(0.8, 0.6, 0.6)); //Back up
    } 
    
}
