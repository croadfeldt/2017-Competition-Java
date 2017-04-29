
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonCenterGear extends CommandGroup 

{    	

	public AutonCenterGear() 
    { 
		addSequential(new ShooterStop());
		//addSequential(new AutonDrive(6.34, -0.53, -0.51)); //Drive forward
		addSequential(new AutonDrive(2.9, -0.70, -0.70)); //Drive forward
    	addSequential(new WaitCommand(.5));
//     	addSequential(new AutonDrive(1.0, 0.0, 0.0)); //Stop
    	addSequential(new GearDeploy());  //Deploy the gear
    	addSequential(new WaitCommand(.5));
     	addSequential(new AutonDrive(1.8, 0.6, 0.6)); //Back up
     	addSequential(new GearDeployComplete()); //Bring up gearintake
    } 
    
}
