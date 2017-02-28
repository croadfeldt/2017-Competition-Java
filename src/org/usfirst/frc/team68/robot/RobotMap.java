package org.usfirst.frc.team68.robot;


public class RobotMap {
	
    private static RobotMap robotMap;
        
    public static RobotMap getRobotMap() {
    	if( robotMap == null) {
    		robotMap = new RobotMap();
    	}
    	return robotMap;
    }
     
    public static final int DRIVETRAIN_FL = 1;
    public static final int DRIVETRAIN_FR = 3;
    public static final int DRIVETRAIN_RL = 2;
    public static final int DRIVETRAIN_RR = 4;


    public static final int GEAR_IN = 1;
    public static final int GEAR_OUT = 2;

    public static final int DRIVETRAIN_SHIFT_LOW = 5;
    public static final int DRIVETRAIN_SHIFT_HIGH = 6;
    
    public static final int INTAKE_SPEED_FORWARD = 1;
    public static final int INTAKE_SPEED_REVERSE = 0;
    public static final int INTAKE_MOTOR = 2;
    
    public static final int CLIMBER_LATCH_OPEN = 3;
    public static final int CLIMBER_LATCH_CLOSE = 4;
    
    public static final int XBOX_DRIVE_CONTROLLER = 0;
    public static final int XBOX_MANIPULATOR_CONTROLLER = 1;
    
    public static final int XBOX_DRIVE_B = 2;
    public static final int XBOX_DRIVE_X = 3;
    public static final int XBOX_DRIVE_Y = 4;
    
    public static final int XBOX_DRIVE_LY = 1;
    public static final int XBOX_DRIVE_LT = 2;
    public static final int XBOX_DRIVE_RT = 3;
    public static final int XBOX_DRIVE_RY = 5;
    
    public static final int XBOX_DRIVE_BS = 8;
    
    public static final int XBOX_MANIPULATOR_A = 1;
    public static final int XBOX_MANIPULATOR_B = 2;
    public static final int XBOX_MANIPULATOR_X = 3;
    public static final int XBOX_MANIPULATOR_Y = 4;
    public static final int XBOX_MANIPULATOR_RB = 5;
    public static final int XBOX_MANIPULATOR_LB = 6;
    
    public static final int XBOX_MANIPULATOR_LT = 2;
    public static final int XBOX_MANIPULATOR_RT = 3;
    
    public static final int XBOX_MANIPULATOR_BB = 7;    
    public static final int XBOX_MANIPULATOR_BS = 8;
    
    // Custom user defined methods should go here
    // add a comment

    
}


