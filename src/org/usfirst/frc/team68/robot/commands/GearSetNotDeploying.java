package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;

public class GearSetNotDeploying extends Command {
	boolean isFinished = false;

    public GearSetNotDeploying() 
   {
    	requires(Robot.gear);
    }

    protected void initialize() 
    {

    }

    protected void execute()
   {
    	Robot.gear.setGearIsDeploying(false);
    	isFinished = true;
    }

    protected boolean isFinished() 
   {
        return isFinished;
    }

    protected void end() 
   {

    }

    protected void interrupted() 
    {

    }
}


