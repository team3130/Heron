package org.usfirst.frc.team3130.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class BasicCanTalon extends Subsystem {

	private CANTalon m_motor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public BasicCanTalon(int id, String subsystem, String name)
    {
    	m_motor = new CANTalon(id);
    	LiveWindow.addActuator(subsystem, name, m_motor);
    }
    
    public double getPVbus(){
    	return m_motor.get();
    }
    
    public void setSpeed(double PVbus)
    {
    	m_motor.set(PVbus);
    }
    
}

