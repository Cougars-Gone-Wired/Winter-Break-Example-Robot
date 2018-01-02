package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drive {

	private RobotDrive robotDrive;
	private Joystick mobilityStick;

	public Drive(Robot robot) {
		this.mobilityStick = robot.getMobilityStick();
		this.robotDrive = robot.getRobotDrive();
	}

	public void drive() {
		robotDrive.arcadeDrive(
				DeadZone.deadZone(mobilityStick.getRawAxis(Robot.DRIVE_FORWARD)),
				DeadZone.deadZone(mobilityStick.getRawAxis(Robot.DRIVE_TURN))
				);
	}
}
