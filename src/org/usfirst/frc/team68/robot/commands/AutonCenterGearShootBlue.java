
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonCenterGearShootBlue extends CommandGroup 
{    	

	public AutonCenterGearShootBlue() 
    { 
		addSequential(new AutonDrive(2.7, -0.70, -0.70)); //Drive forward
		addParallel(new IntakeDown());//Put the intake down
    	addSequential(new WaitCommand(1));
    	addSequential(new GearDeploy());  //Deploy the gear
    	addSequential(new WaitCommand(1));
     	addSequential(new AutonDrive(1.7, 0.53, 0.51)); //Back up
     	addSequential(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));
     	addParallel(new IntakeForward());
     	addParallel(new AutonDrive(3.8, -.53, .51));  // Turn Right 
     	addSequential(new WaitCommand(1));
     	addSequential(new ShooterFeederForward());
		
    } 
}
