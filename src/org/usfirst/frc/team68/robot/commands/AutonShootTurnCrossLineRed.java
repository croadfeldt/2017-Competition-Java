package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;


public class AutonShootTurnCrossLineRed extends CommandGroup 
{    	

	public AutonShootTurnCrossLineRed() 
    { 
		addParallel(new ShooterStart(0, RobotMap.SHOOTER_HOOD_SHORT, 0));
		addParallel(new IntakeDown()); //Put the intake down
     	addSequential(new WaitCommand(.5));
     	addParallel(new ShooterStart(RobotMap.SHOOTER_SPEED_SHORT, RobotMap.SHOOTER_HOOD_SHORT, RobotMap.SHOOTER_FEEDER_SPEED_SHORT));
     	addParallel(new IntakeForward());
     	addSequential(new WaitCommand(1));
     	addParallel(new ShooterFeederForward());
     	addSequential(new WaitCommand(7));
     	addSequential(new IntakeStop());
     	addSequential(new ShooterStop());
     	addSequential(new ShooterFeederStop());
     	addSequential(new DriveMM(4.5,0,240,0,240,0)); //Turn using left side only
    	addSequential(new WaitCommand(.5));
    	addSequential(new DriveMM(6.0,-6.0,240,240,240,240));  
    } 
    
}
