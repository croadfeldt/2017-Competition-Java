
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonStartShooter extends CommandGroup 

{    	

	public AutonStartShooter() 
    { 
     	addSequential(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));    
    } 
    
}
