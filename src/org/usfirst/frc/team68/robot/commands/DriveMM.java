package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.Robot;

/**
 *
 */
public class DriveMM extends Command {
	boolean isFinished = false;
	private double targetPosLeft;
	private double targetPosRight;
	private double targetCruiseLeft;
	private double targetCruiseRight;
	private double targetAccelLeft;
	private double targetAccelRight;

    public DriveMM(double leftPos, double rightPos, double leftCruise, double rightCruise, double leftAccel, double rightAccel) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    	targetPosLeft = leftPos;
    	targetPosRight = rightPos;
    	targetCruiseLeft = leftCruise;
    	targetCruiseRight = rightCruise;
    	targetAccelLeft = leftAccel;
    	targetAccelRight = rightAccel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setModeMotionMagic();
    	Robot.driveTrain.setMotionMagicProfile(targetCruiseLeft,targetAccelLeft,targetCruiseRight,targetAccelRight);
    	Robot.driveTrain.setMotionMagicPosition(targetPosLeft,targetPosRight);    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	SmartDashboard.putNumber("Right Position: ", targetPosRight);
    	SmartDashboard.putNumber("Left Position: ", targetPosLeft);
    	SmartDashboard.putNumber("Closed Loop Error Right: ", Robot.driveTrain.getClosedLoopErrorRight());
/*    	SmartDashboard.putNumber("Right Position: ", Robot.driveTrain.getPositionRight());
    	SmartDashboard.putNumber("Left Position: ", Robot.driveTrain.getPositionLeft());

    	SmartDashboard.putNumber("Closed Loop Error Left: ", Robot.driveTrain.getClosedLoopErrorLeft());
    	SmartDashboard.putNumber("Left Drive Speed: ", Robot.driveTrain.getDriveLeftSpeed());
    	SmartDashboard.putNumber("Left Drive Speed 2: ", Robot.driveTrain.getDriveLeftSpeed2());
    	SmartDashboard.putNumber("Right Drive Speed: ", Robot.driveTrain.getDriveRightSpeed());
*/
    	isFinished = Math.abs(Robot.driveTrain.getPositionLeft()) >= Math.abs(targetPosLeft*.95) && Math.abs(Robot.driveTrain.getPositionRight()) >= Math.abs(targetPosRight*.95);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setModePercentVbus();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	this.end();
    }
}
