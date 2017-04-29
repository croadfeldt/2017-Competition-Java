
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Auton3 extends CommandGroup {

    public Auton3() {
    	
    	addSequential(new WaitCommand(3));
    	
    } 
    
}