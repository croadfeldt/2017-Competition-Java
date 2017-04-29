package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;

/**
 *
 */
public class AutonDrive extends Command {
	boolean isFinished = false;
	double timeLimit = 0.0;
	double timeToRun = 0.0;
	double leftSpeed = 0.0;
	double rightSpeed = 0.0;
	Timer timer = new Timer();
	
	
    public AutonDrive(double time, double left, double right)
    {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    	timeToRun = time;
    	leftSpeed = left;
    	rightSpeed = right;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeLimit = timeToRun + Timer.getFPGATimestamp();     
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
    	if(Timer.getFPGATimestamp() > timeLimit)
    	{
    		isFinished = true;
    	}
    	else
    	{
    		isFinished = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankDrive(0.0 , 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}