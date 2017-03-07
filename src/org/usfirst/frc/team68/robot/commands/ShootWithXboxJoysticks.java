package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;


public class ShootWithXboxJoysticks extends Command {
	
	boolean isFinished = false;
	
	
	public ShootWithXboxJoysticks() {
		
//		requires(Robot.shooter2);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
//   		Robot.shooter2.setShooter2Speed(Robot.oi.getLeftXboxJoystick()*500);
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}


