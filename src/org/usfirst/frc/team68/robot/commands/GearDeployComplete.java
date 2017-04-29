
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class GearDeployComplete extends CommandGroup {    	

	public GearDeployComplete() { 
		addSequential(new GearSetNotDeploying());
		addSequential(new GearGrabberUp());
     	addParallel(new GearIntakeDeploy(RobotMap.GEAR_INTAKE_STOP));  
    } 
    
}
