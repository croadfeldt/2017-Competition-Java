package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;

/**
 *
 */
public class IntakeReverse extends Command {
	
	boolean isFinished = false;
	double intakePOV = 0;
	
	public IntakeReverse() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.intake.setIntakeReverseSpeed(Robot.oi.getXboxManipulateLT()*-1);
		
		// Check the DPad on the driver controller and put intake
		// up or down based on its value.
		intakePOV = Robot.oi.getLeftXboxDrivePOV();
		if (intakePOV == 0) 
		{
			Scheduler.getInstance().add(new IntakeUp());
		} else if (intakePOV == 180) 
		{
			Scheduler.getInstance().add(new IntakeDown());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {

	}
}
