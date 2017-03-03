package org.usfirst.frc.team68.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
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


    public static final int GEAR_IN = 5;
    public static final int GEAR_OUT = 4;

    public static final int DRIVETRAIN_SHIFT_LOW = 5;
    public static final int DRIVETRAIN_SHIFT_HIGH = 6;
    
    public static final double INTAKE_SPEED_FORWARD = 0.5;
    public static final double INTAKE_SPEED_STOP = 0;
    public static final double INTAKE_SPEED_REVERSE = -0.5;
    public static final int INTAKE_MOTORS = 1;  						// Two motors PWM channel 1 with Y cable
    
    public static final int CLIMBER_LOCK = 3;
    public static final int CLIMBER_UNLOCK = 2;
    
    public static final int XBOX_DRIVE = 0;
    
    public static final int XBOX_DRIVE_B = 2;
    public static final int XBOX_DRIVE_X = 3;
    public static final int XBOX_DRIVE_Y = 4;
    public static final int XBOX_DRIVE_LY = 1;			// left joystick
    public static final int XBOX_DRIVE_LT = 2;
    public static final int XBOX_DRIVE_RT = 3;
    public static final int XBOX_DRIVE_RY = 5;			// right joystick
    public static final int XBOX_DRIVE_BS = 8;
    public static final int XBOX_DRIVE_RB = 5;
    public static final int XBOX_DRIVE_LB = 6;
 
    
    public static final int XBOX_MANIPULATE = 1;
    public static final int XBOX_MANIPULATE_A = 1;
    public static final int XBOX_MANIPULATE_B = 2;
    public static final int XBOX_MANIPULATE_X = 3;
    public static final int XBOX_MANIPULATE_Y = 4;
    public static final int XBOX_MANIPULATE_RB = 5;
    public static final int XBOX_MANIPULATE_LB = 6;
    public static final int XBOX_MANIPULATE_LT = 2;
    public static final int XBOX_MANIPULATE_RT = 3;
    public static final int XBOX_MANIPULATE_BB = 7;    
    public static final int XBOX_MANIPULATE_BS = 8;
    

    public static final double SHOOTER_FEEDER_SPEED_FORWARD = 0.3;
    public static final double SHOOTER_FEEDER_SPEED_STOP = 0;
    public static final double SHOOTER_FEEDER_SPEED_REVERSE = -0.3;
    public static final int SHOOTER_FEEDER_MOTOR = 2;
    public static final int SHOOTER_PRIMARY_MOTOR = 5;  	
    public static final int SHOOTER_FOLLOWER_MOTOR = 6; 	
    public static final double SHOOTER_SPEED_STOP = 0;
    public static final double SHOOTER_SPEED_SHORT = 300;
    public static final double SHOOTER_SPEED_MEDIUM = 600;
    public static final double SHOOTER_SPEED_LONG = 1000;
    public static final double SHOOTER_HOOD_SHORT = .3;
    public static final double SHOOTER_HOOD_MEDIUM = .6;
    public static final double SHOOTER_HOOD_LONG = .9;
    public static final double SHOOTER_HOOD_STOP = .1;
    
    public static final int SHOOTER_PID_SLOT = 0;
    public static final double SHOOTER_PID_F = 0.0;
    public static final double SHOOTER_PID_P = 0.210;
    public static final double SHOOTER_PID_I = 0.0000264;
    public static final double SHOOTER_PID_D = 0.0;

    public static final int PCM_MAIN = 9;
    
    // Custom user defined methods should go here
    // add a comment

    
}


