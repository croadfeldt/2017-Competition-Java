
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Auton1 extends CommandGroup {

    public Auton1() { 
    	addSequential( new DriveStraightDeadReckoning() );
    	addSequential( new WaitCommand(3));
    	addSequential( new DriveStop());
    } 
}