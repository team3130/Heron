package org.usfirst.frc.team3130.robot;

import org.usfirst.frc.team3130.robot.commands.ControlBasicCanTalon;
import org.usfirst.frc.team3130.robot.commands.RunShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static OI m_instance;
	public static OI getInstance(){
		if (m_instance==null) m_instance = new OI();
		return m_instance;
	}
	
	private static Joystick gamepad;
	
	private static JoystickButton runShooter;
	private static JoystickButton runFeeder;
	private static JoystickButton runLAdj;
	private static JoystickButton runRAdj;
	
	private static ControlBasicCanTalon feeder;
	private static ControlBasicCanTalon RAdj;
	private static ControlBasicCanTalon LAdj;
	
	private OI(){
		gamepad = new Joystick(0);
		
		runShooter = new JoystickButton(gamepad, RobotMap.BTN_SHOOT);
		runFeeder = new JoystickButton(gamepad, RobotMap.BTN_FEED);
		runLAdj = new JoystickButton(gamepad, RobotMap.BTN_RUNADJ);
		runRAdj = new JoystickButton(gamepad, RobotMap.BTN_RUNADJ);
		
		feeder = new ControlBasicCanTalon(Robot.feeder);
		feeder.setSpeed(Preferences.getInstance().getDouble("Feeder", .5));
		
		RAdj = new ControlBasicCanTalon(Robot.RAdj);
		RAdj.setSpeed(Preferences.getInstance().getDouble("Adj", .42));
		
		LAdj = new ControlBasicCanTalon(Robot.LAdj);
		LAdj.setSpeed(Preferences.getInstance().getDouble("Adj", .42));
		
		runShooter.whileHeld(new RunShooter());
		runFeeder.whileHeld(feeder);
		
		runLAdj.whileHeld(LAdj);
		runRAdj.whileHeld(RAdj);
	}
}
