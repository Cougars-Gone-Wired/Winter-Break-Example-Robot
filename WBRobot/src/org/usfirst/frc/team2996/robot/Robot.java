package org.usfirst.frc.team2996.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class Robot extends IterativeRobot {

	static int MOBILITY_STICK;
	
	static int DRIVE_FORWARD;
	static int DRIVE_TURN;
	
	static int MANIPULATOR_STICK;
	
	static int INTAKE_TRIGGER;
	static int OUTTAKE_TRIGGER;
	static int GEAR_PAN_BUTTON;
	
	static int FRONT_LEFT_MOTOR_ID;
	static int REAR_LEFT_MOTOR_ID;
	static int FRONT_RIGHT_MOTOR_ID;
	static int REAR_RIGHT_MOTOR_ID;
	
	static int GEAR_PAN_MOTOR_ID;
	
	static int GEAR_PAN_SOLENOID_ID;
	
	RobotDrive robotDrive;
	
	Joystick mobilityStick;
	
	Joystick manipulatorStick;
	
	Toggle gearPanButton;
	
	CANTalon frontLeftMotor;
	CANTalon rearLeftMotor;
	CANTalon frontRightMotor;
	CANTalon rearRightMotor;
	
	CANTalon gearPanMotor;
	
	Solenoid gearPanSolenoid;
	
	Drive drive;
	GearPan gearPan;
	
	@Override
	public void robotInit() {
		setConstants();
		
		mobilityStick = new Joystick(MOBILITY_STICK);
		
		manipulatorStick = new Joystick(MANIPULATOR_STICK);
		
		gearPanButton = new Toggle(manipulatorStick, GEAR_PAN_BUTTON);
		
		frontLeftMotor = new CANTalon(FRONT_LEFT_MOTOR_ID);
		rearLeftMotor = new CANTalon(REAR_LEFT_MOTOR_ID);
		frontRightMotor = new CANTalon(FRONT_RIGHT_MOTOR_ID);
		rearRightMotor = new CANTalon(REAR_RIGHT_MOTOR_ID);
		
		robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		
		gearPanMotor = new CANTalon(GEAR_PAN_MOTOR_ID);
		
		gearPanSolenoid = new Solenoid(GEAR_PAN_SOLENOID_ID);
		
		drive = new Drive(this);
		gearPan = new GearPan(this);
	}

	@Override
	public void teleopPeriodic() {
		drive.drive();
		
		gearPan.gearInatkeOuttake();
		gearPan.gearPanUpDown();
	}
	
	public static void setConstants() {
		
		MOBILITY_STICK = 0;
		
		DRIVE_FORWARD = 1;
		DRIVE_TURN = 4;
		
		MANIPULATOR_STICK = 1;
		
		INTAKE_TRIGGER = 3;
		OUTTAKE_TRIGGER = 2;
		GEAR_PAN_BUTTON = 2;
		
		FRONT_LEFT_MOTOR_ID = 0;
		REAR_LEFT_MOTOR_ID = 1;
		FRONT_RIGHT_MOTOR_ID = 2;
		REAR_RIGHT_MOTOR_ID = 3;
		
		GEAR_PAN_MOTOR_ID = 4;
		
		GEAR_PAN_SOLENOID_ID = 0;
		
	}
	
	public RobotDrive getRobotDrive() {
		return robotDrive;
	}

	public Joystick getMobilityStick() {
		return mobilityStick;
	}

	public Joystick getManipulatorStick() {
		return manipulatorStick;
	}

	public Toggle getGearPanButton() {
		return gearPanButton;
	}

	public CANTalon getGearPanMotor() {
		return gearPanMotor;
	}

	public Solenoid getGearPanSolenoid() {
		return gearPanSolenoid;
	}
	
}
