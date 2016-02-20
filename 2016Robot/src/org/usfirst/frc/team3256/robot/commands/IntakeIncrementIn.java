package org.usfirst.frc.team3256.robot.commands;

import org.usfirst.frc.team3256.robot.Robot;
import org.usfirst.frc.team3256.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIncrementIn extends Command {
	
	int speed;
	int ticks;
	public IntakeIncrementIn(int speed, int ticks) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake); 
    	this.speed=speed;
    	this.ticks=ticks;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Intake.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.incrementIn(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Intake.getEncoderValue()>=ticks){
        	return true;
        }
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Intake.incrementIn(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
