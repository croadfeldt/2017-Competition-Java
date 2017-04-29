
package org.usfirst.frc.team68.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

    public class AutonLeft2 extends CommandGroup 
    {

        public AutonLeft2() 
        {
        	//HOOD NEEDS TO BE BROUGHT DOWN
        	addSequential(new ShooterStop());
        	//addParallel(new AutonDrive(2.7, -0.73, -0.71)); //Drive forward
        	addSequential(new AutonDrive(3.2, -0.71, -0.71)); //Drive forward
        	//addSequential(new AutonDrive(2.6, 0.53, -0.51)); // Turn right
        	addSequential(new AutonDrive(2.5, -0.53, 0.51)); // Turn right
        	//addSequential(new AutonDrive(2.4, -0.63, -0.61));  //Drive forward 
        	addSequential(new AutonDrive(0.8, -0.63, -0.61));  //Drive forward 
        	addSequential(new WaitCommand(0.5));
         	addSequential(new GearDeploy());  // Spin the gear motors
         	//addSequential(new AutonDrive(1.2, 0.53, 0.51)); //Drive backward
         	addSequential(new AutonDrive(2.4, 0.6, 0.6)); //Drive backward
         	addSequential(new GearDeployComplete()); //Bring up gearintake
         	addSequential(new AutonDrive(2.8, 0.53, -0.51)); //Turn left
         	addSequential(new WaitCommand(0.5));
         	addSequential(new DriveShiftHigh());
         	addSequential(new AutonDrive(1.5, -0.71, -0.71));
         	/*
         	 *addSequential(new AutonDrive(6.35, -0.53, -0.51)); //Drive forward
        	addSequential(new AutonDrive(2.45, 0.53, -0.51)); // Turn left
        	addSequential(new AutonDrive(3.0, -0.53, -0.51));  //Drive forward 
         	addSequential(new GearDeploy());  // Spin the gear motors
         	addSequential(new AutonDrive(1.35, 0.53, 0.51)); //Drive backward
         	 */

        } 
}