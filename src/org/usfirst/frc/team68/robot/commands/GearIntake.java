package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;


public class GearIntake extends Command {
	
	boolean isFinished = false;
	double gearPOV = 0;
	
	
	public GearIntake() {
		requires(Robot.gear);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (!Robot.gear.isGearDeploying())
			Robot.gear.setIntakeSpeed(Robot.oi.getRightXboxManipulatorJoystick());
		// Check the value of the manipulator xbox controller POV
		// and trigger the grabber up or down
		gearPOV = Robot.oi.getLeftXboxManipulatorPOV();
//		SmartDashboard.putNumber("POV Angle is: ", gearPOV);
		if (gearPOV == 0) {
			Scheduler.getInstance().add(new GearGrabberUp());
		} else if (gearPOV == 180) {
			Scheduler.getInstance().add(new GearGrabberDown());
		}
		SmartDashboard.putBoolean("Gear Is Deploying :", Robot.gear.isGearDeploying());
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


