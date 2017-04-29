package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;


public class GearIntakeDeploy extends Command {
	
	boolean isFinished = false;
	private double targetSpeed = 0;
	
	
	public GearIntakeDeploy(double speed) {
		requires(Robot.gear);
		targetSpeed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
   		Robot.gear.setIntakeSpeed(targetSpeed);
//   		SmartDashboard.putNumber("Gear Intake Speed: ", targetSpeed) ;
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


