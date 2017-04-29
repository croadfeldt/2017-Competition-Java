package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;


public class GearIntakeStop extends Command {
	
	boolean isFinished = false;
	
	
	public GearIntakeStop() {
		requires(Robot.gear);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
   		Robot.gear.setIntakeSpeed(RobotMap.GEAR_INTAKE_STOP);
   		isFinished = true;
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


