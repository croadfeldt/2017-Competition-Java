
package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonCenterGearShootRed extends CommandGroup 
{    	

	public AutonCenterGearShootRed() 
    { 
		addParallel(new ShooterStop()); // This command is more for positioning the hood initially
		addParallel(new IntakeDown());//Put the intake down
		addSequential(new AutonDrive(2.7, -0.70, -0.70)); //Drive forward
    	addSequential(new WaitCommand(.25));
    	addSequential(new GearDeploy());  //Deploy the gear
    	addSequential(new WaitCommand(.25));
     	addSequential(new AutonDrive(1.7, 0.53, 0.51)); //Back up
     	addParallel(new AutonDrive(3.8, .53, -.51));  // Turn Left 
     	addParallel(new ShooterStart(RobotMap.SHOOTER_SPEED_MEDIUM, RobotMap.SHOOTER_HOOD_MEDIUM, RobotMap.SHOOTER_FEEDER_SPEED_MEDIUM));
     	addParallel(new IntakeForward());
     	addSequential(new WaitCommand(1));
     	addSequential(new ShooterFeederForward());
     	
    } 
    
}
