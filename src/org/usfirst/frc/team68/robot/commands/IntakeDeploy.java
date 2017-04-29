package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;


public class IntakeDeploy extends Command {
	
	boolean isFinished = false;
	double intakePOV = 0;
	
	
	public IntakeDeploy() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() 
	{
		intakePOV = Robot.oi.getLeftXboxDrivePOV();
		if (intakePOV == 0) 
		{
			Scheduler.getInstance().add(new IntakeUp());
		} else if (intakePOV == 180) 
		{
			Scheduler.getInstance().add(new IntakeDown());
		}
	}

	@Override
	protected boolean isFinished() 
	{
		return isFinished;
	}

	@Override
	protected void end() 
	{
		
	}

	@Override
	protected void interrupted() 
	{
		
	}
}


