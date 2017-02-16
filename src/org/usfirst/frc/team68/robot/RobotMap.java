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
    
    public static final int GEAR_IN = 1;
    public static final int GEAR_OUT = 0;
    
    public static final int INTAKE_SPEED_FORWARD = 1;
    public static final int INTAKE_SPEED_REVERSE = 0;
    public static final int INTAKE_MOTOR = 2;
    
    public static final int CLIMBER_LOCK = 0;
    public static final int CLIMBER_UNLOCK = 1;
    
    
    // Custom user defined methods should go here

    
}


