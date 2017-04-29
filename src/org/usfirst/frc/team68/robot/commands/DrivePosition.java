package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team68.robot.Robot;
import org.usfirst.frc.team68.robot.RobotMap;

/**
 *
 */
public class DrivePosition extends Command {
	
	private boolean isFinished = false;
	double targetPositionLeft = 0;
	double targetPositionRight = 0;
	double currentPositionLeft = 0;
	double currentPositionRight = 0;
	double averagedPosition = 0;
	double percentComplete = 0;
	double speedPercentageMultiplier = 0;
	double leftSpeed = 0;
	double rightSpeed = 0;
	
    public DrivePosition(double leftPos, double rightPos, double leftSpd, double rightSpd)
    {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    	
    	targetPositionLeft = leftPos;
    	targetPositionRight = rightPos;
    	leftSpeed = leftSpd;
    	rightSpeed = rightSpd;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPositionLeft = Robot.driveTrain.getPositionLeft();
    	currentPositionRight = Robot.driveTrain.getPositionRight();
    	averagedPosition = (currentPositionLeft + currentPositionRight) / 2;
    	percentComplete = (averagedPosition / targetPositionRight) * 100;
    	
    	if(percentComplete <= 10) {
    		speedPercentageMultiplier = .30;   // 30 percent of target speed
    	} else if(percentComplete <= 20) {
    		speedPercentageMultiplier = .60;   // 60 percent of target speed
    	} else if(percentComplete <= 70) {
    		speedPercentageMultiplier = 1.0;   // 100 percent of target speed
    	} else if(percentComplete <= 80) {
    		speedPercentageMultiplier = .60;   // 60 percent of target
    	} else if(percentComplete <= 97) {
    		speedPercentageMultiplier = .30;   // 30 percent of target
    	} else {
    		speedPercentageMultiplier = 0.0;   // 0 percent of target
    		isFinished = true;
    	}
    		
    	Robot.driveTrain.tankDrive(leftSpeed*speedPercentageMultiplier, rightSpeed*speedPercentageMultiplier);
    	
//   	isFinished = currentPositionLeft >= targetPositionLeft*.95 && currentPositionRight >= targetPositionRight*.95;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the drivetrain
//   	Robot.driveTrain.tankDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}