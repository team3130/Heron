package org.usfirst.frc.team3130.robot.commands;

import org.usfirst.frc.team3130.robot.subsystems.BasicCanTalon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlBasicCanTalon extends Command {

	private BasicCanTalon motor;
	private double PVbus;
	
    public ControlBasicCanTalon(BasicCanTalon motor) {
		this.motor = motor;
        requires(motor);
    }

    public void setSpeed(double PVbus)
    {
    	this.PVbus = PVbus;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	motor.setSpeed(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	motor.setSpeed(PVbus);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	motor.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
