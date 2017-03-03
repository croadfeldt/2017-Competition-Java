package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;

/**
 *
 */
public class ShooterStart extends Command {
	
	private boolean isFinished = false;
	private double speed;
	private double position;
	
	public ShooterStart(double shooterRPMValue, double hoodPosition) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
		speed = shooterRPMValue;
		position = hoodPosition;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shooter.setHood(position);
		Robot.shooter.setShooterSpeed(speed);
		isFinished = true;
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
