package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;

public class IntakeDown extends Command 
{
	boolean isFinished = false;

    public IntakeDown() 
   {
    	requires(Robot.gear);
    }

    protected void initialize() 
    {

    }

    protected void execute()
   {
    	Robot.intake.intakeDown();
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


