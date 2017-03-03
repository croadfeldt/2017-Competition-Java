package org.usfirst.frc.team68.robot.commands;

import org.usfirst.frc.team68.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class ClimberLock extends Command {
	boolean isFinished = false;

    public ClimberLock() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.climberLock();
    	isFinished = true;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}