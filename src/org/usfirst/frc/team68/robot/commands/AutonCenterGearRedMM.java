
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonCenterGearRedMM extends CommandGroup 
{    	

	public AutonCenterGearRedMM() 
    { 
		
     	addSequential(new DriveMM(-6.0, 6.0, 240,120,240,120)); //Drive forward
    	addSequential(new WaitCommand(1));
//    	addSequential(new GearDeploy());  //Deploy the gear
    	addSequential(new WaitCommand(1));
     	addSequential(new DriveMM(2.0, -2.0, 200,200,200,200)); //Back up
//     	addSequential(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));
//     	addParallel(new IntakeForward());
     	addParallel(new DriveMM(2.0,2.0, 200,200,200,200));  // Turn Left 
//     	addSequential(new WaitCommand(1));
//    	addSequential(new ShooterFeederForward());
     	
		/*
		addSequential(new AutonDrive(6.65, -0.54, -0.51)); //Drive forward *Practice Field .52, .51*
    	addSequential(new WaitCommand(1));
    	addSequential(new GearDeploy());  //Deploy the gear
    	addSequential(new WaitCommand(1));
     	addSequential(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));
     	addParallel(new AutonDrive(1.7, 0.52, 0.51)); //Back up
     	addSequential(new IntakeForward());
     	addParallel(new AutonDrive(6.3, .52, -.51));  // Turn Left 
     	addSequential(new WaitCommand(1));
     	addSequential(new ShooterFeederForward());
     	*/
    } 
    
}
