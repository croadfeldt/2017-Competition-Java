
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class GearDeploy extends CommandGroup {    	

	public GearDeploy() { 
		addSequential(new GearSetDeploying());
		addSequential(new GearIntakeDeploy(RobotMap.GEAR_INTAKE_DEPLOY_SPEED));
     	addParallel(new GearGrabberDown());  
    } 
    
}
