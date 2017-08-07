package org.usfirst.frc.team3130.robot.subsystems;

import org.usfirst.frc.team3130.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private static int ENCODER_TO_REV;
	
	private static Shooter m_instance;
	public static Shooter getInstance(){
		if (m_instance==null) m_instance = new Shooter();
		return m_instance;
	}
	
	private static CANTalon m_shooterMotor1;
	private static CANTalon m_shooterMotor2;
	
	private Shooter(){
		m_shooterMotor1 = new CANTalon(RobotMap.CAN_SHOOTER1);
		m_shooterMotor2 = new CANTalon(RobotMap.CAN_SHOOTER2);
		
		LiveWindow.addActuator("Shooter", "Motor1", m_shooterMotor1);
		LiveWindow.addActuator("Shooter", "Motor2", m_shooterMotor2);
		
		m_shooterMotor2.changeControlMode(TalonControlMode.Follower);
		m_shooterMotor2.set(RobotMap.CAN_SHOOTER1);
		
		m_shooterMotor1.changeControlMode(TalonControlMode.PercentVbus);
		m_shooterMotor1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		m_shooterMotor1.configEncoderCodesPerRev(ENCODER_TO_REV);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void setSpeed(double PVBus)
    {
    	m_shooterMotor1.set(PVBus);
    }
    
    public static double getPVbus()
    {
    	return m_shooterMotor1.get();
    }
    
    public static double getSpeed()
    {
    	return m_shooterMotor1.getEncVelocity();
    }
}

