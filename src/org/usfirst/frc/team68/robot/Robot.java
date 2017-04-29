
package org.usfirst.frc.team68.robot;
import org.usfirst.frc.team68.robot.subsystems.DriveCoachAssist;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team68.robot.commands.AutonLeft;
import org.usfirst.frc.team68.robot.commands.AutonCenterGear;
import org.usfirst.frc.team68.robot.commands.AutonCenterGearShootRed;
import org.usfirst.frc.team68.robot.commands.AutonCenterGearShootBlue;
import org.usfirst.frc.team68.robot.commands.AutonRight;
import org.usfirst.frc.team68.robot.commands.AutonShootTurnCrossLineBlue;
import org.usfirst.frc.team68.robot.commands.AutonShootTurnCrossLineRed;
import org.usfirst.frc.team68.robot.commands.AutonTest;
import org.usfirst.frc.team68.robot.commands.ShooterStart;
import org.usfirst.frc.team68.robot.commands.AutonNone;
import org.usfirst.frc.team68.robot.commands.AutonRedRightGear;
import org.usfirst.frc.team68.robot.subsystems.Climber;
import org.usfirst.frc.team68.robot.subsystems.Compressor;
import org.usfirst.frc.team68.robot.subsystems.DriveTrain;
import org.usfirst.frc.team68.robot.subsystems.Gear;
//import org.usfirst.frc.team68.robot.subsystems.Hood;
import org.usfirst.frc.team68.robot.subsystems.Intake;
import org.usfirst.frc.team68.robot.subsystems.Shooter;

import org.usfirst.frc.team68.robot.subsystems.USBCamera;
import org.usfirst.frc.team68.robot.subsystems.Vision;


public class Robot extends IterativeRobot {
	
	public static RobotMap robotMap;
	public static USBCamera usbCamera;
	public static Climber climber;
	public static Compressor compressor;
	public static DriveTrain driveTrain;
	public static Gear gear;
	public static Intake intake;
	public static Shooter shooter;
	public static DriveCoachAssist DCA;
	public static Vision vision;
	public static OI oi;
	
	/* shooter debug PID variables
	private double F;
	private double P;
	private double I;
	private double D;
	private double H;
	*/
	
	//* Drive Left debug PID variables
/*	private double FL;
	private double PL;
	private double IL;
	private double DL;
	private double leftTargetSpeed= 0;
	
	//* Drive Right debug PID variables
/*	private double FR;
	private double PR;
	private double IR;
	private double DR;
	private double rightTargetSpeed= 0;
*/

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// The RobotMap class should be the first to be instantiated
		robotMap = RobotMap.getRobotMap();

		// Create a single instance of each Robot subsystem here
		usbCamera = USBCamera.getCamera();
		climber = Climber.getClimber();
		
		compressor = Compressor.getCompressor();
		driveTrain = DriveTrain.getDriveTrain();
		gear = Gear.getgear();
		intake = Intake.getIntake();
		shooter = Shooter.getShooter();
		
    	DCA = DriveCoachAssist.getDCA();
//		vision = Vision.getVision();
		       
    	chooser.addDefault("Auton Center Gear ", new AutonCenterGear());
        chooser.addObject("Auton None ", new AutonNone());
        chooser.addObject("Auton RED Shoot Cross Line ", new AutonShootTurnCrossLineRed());
        chooser.addObject("Auton BLUE Shoot Cross Line ", new AutonShootTurnCrossLineBlue());     
        chooser.addObject("Auton Right Gear Peg ", new AutonRight());
        chooser.addObject("Auton Left Gear Peg ", new AutonLeft());



        SmartDashboard.putData("Auto mode", chooser);
         
         
		// The OI class should be the last to be instantiated
		oi = OI.getOI();
		
//		SmartDashboard.putData("Test Auton MM", new AutonTest());
		
/*		SmartDashboard.putNumber("SHOOTER_PID_F", 0);
		SmartDashboard.putNumber("SHOOTER_PID_P", 0);
		SmartDashboard.putNumber("SHOOTER_PID_I", 0);
		SmartDashboard.putNumber("SHOOTER_PID_D", 0);
		SmartDashboard.putNumber("Hood Position: ", .1);
*/		
/*		SmartDashboard.putNumber("DRIVE_LEFT_TARGET_SPEED: ",leftTargetSpeed);
		SmartDashboard.putNumber("DRIVE_LEFT_PID_F", RobotMap.DRIVETRAIN_LEFT_PID_F);
		SmartDashboard.putNumber("DRIVE_LEFT_PID_P", RobotMap.DRIVETRAIN_LEFT_PID_P);
		SmartDashboard.putNumber("DRIVE_LEFT_PID_I", RobotMap.DRIVETRAIN_LEFT_PID_I);
		SmartDashboard.putNumber("DRIVE_LEFT_PID_D", RobotMap.DRIVETRAIN_LEFT_PID_D);
		
/*		SmartDashboard.putNumber("DRIVE_RIGHT_PID_F", RobotMap.DRIVETRAIN_RIGHT_PID_F);
		SmartDashboard.putNumber("DRIVE_RIGHT_PID_P", RobotMap.DRIVETRAIN_RIGHT_PID_P);
		SmartDashboard.putNumber("DRIVE_RIGHT_PID_I", RobotMap.DRIVETRAIN_RIGHT_PID_I);
		SmartDashboard.putNumber("DRIVE_RIGHT_PID_D", RobotMap.DRIVETRAIN_RIGHT_PID_D);
		SmartDashboard.putNumber("DRIVE_RIGHT_TARGET_SPEED: ",rightTargetSpeed);
*/

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
        Scheduler.getInstance().add(new ShooterStart(0, RobotMap.SHOOTER_HOOD_SHORT, 0));
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.setShifterLow();
		Robot.climber.climberUnlock();

		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		//driveTrain.GetLeftFront().enableBrakeMode(true);
		//driveTrain.GetRightFront().enableBrakeMode(true);
		
		//schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.driveTrain.setModePercentVbus();
    	Robot.driveTrain.setShifterHigh();
    	Robot.driveTrain.zeroEncoders();
		Robot.climber.climberUnlock();
		Robot.intake.intakeUp();
        DCA.zeroTimer();
        // ME
//        Scheduler.getInstance().add(new IntakeStop());
//        Scheduler.getInstance().add(new ShooterStop());
//        Scheduler.getInstance().add(new ShooterFeederStop());

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
/*		F = SmartDashboard.getNumber("SHOOTER_PID_F",F);
		P = SmartDashboard.getNumber("SHOOTER_PID_P",P);
		I = SmartDashboard.getNumber("SHOOTER_PID_I",I);
    	D = SmartDashboard.getNumber("SHOOTER_PID_D",D);
*/
    	
//    	H = SmartDashboard.getNumber("Hood Position: ",H);
//    	shooter.setShooterPID(F,P,I,D);
//    	shooter.setHood(H);
    	
//		System.out.println(shooter.getPIDReport());
		
/*		FL = SmartDashboard.getNumber("DRIVE_LEFT_PID_F",FL);
		PL = SmartDashboard.getNumber("DRIVE_LEFT_PID_P",PL);
		IL = SmartDashboard.getNumber("DRIVE_LEFT_PID_I",IL);
    	DL = SmartDashboard.getNumber("DRIVE_LEFT_PID_D",DL);
    	leftTargetSpeed = SmartDashboard.getNumber("DRIVE_LEFT_TARGET_SPEED: ", leftTargetSpeed);
    	driveTrain.setDriveLeftPID(FL,PL,IL,DL,leftTargetSpeed);
		System.out.println(driveTrain.getPIDReportLeft());

		
/*		FR = SmartDashboard.getNumber("DRIVE_RIGHT_PID_F",FR);
		PR = SmartDashboard.getNumber("DRIVE_RIGHT_PID_P",PR);
		IR = SmartDashboard.getNumber("DRIVE_RIGHT_PID_I",IR);
    	DR = SmartDashboard.getNumber("DRIVE_RIGHT_PID_D",DR);
    	rightTargetSpeed = SmartDashboard.getNumber("DRIVE_RIGHT_TARGET_SPEED: ", rightTargetSpeed);
    	driveTrain.setDriveRightPID(FR,PR,IR,DR,rightTargetSpeed);
		System.out.println(driveTrain.getPIDReportRight());
*/		
		

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

}
