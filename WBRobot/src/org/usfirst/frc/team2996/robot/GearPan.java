package org.usfirst.frc.team2996.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class GearPan {

	private CANTalon gearPanMotor;
	private Solenoid gearPanSolenoid;
	
	private Joystick manipulatorStick;
	
	private Toggle gearPanButton;
	
	public GearPan(Robot robot) {
		this.gearPanMotor = robot.getGearPanMotor();
		this.gearPanSolenoid = robot.getGearPanSolenoid();
		this.manipulatorStick = robot.getManipulatorStick();
		this.gearPanButton = robot.getGearPanButton();
	}
	
	public void gearInatkeOuttake() {
		if ((manipulatorStick.getRawAxis(Robot.INTAKE_TRIGGER) > 0.15) && (manipulatorStick.getRawAxis(Robot.OUTTAKE_TRIGGER) > 0.15)) {
			gearPanMotor.set(0);
		} else if (manipulatorStick.getRawAxis(Robot.INTAKE_TRIGGER) > 0.15) {
			gearPanMotor.set(1);
		} else if (manipulatorStick.getRawAxis(Robot.OUTTAKE_TRIGGER) > 0.15) {
			gearPanMotor.set(-1);
		} else {
			gearPanMotor.set(0);
		}
	}
	
	public void gearPanUpDown() {   
		if(gearPanButton.toggle()) {
			gearPanSolenoid.set(true);
		} else {
			gearPanSolenoid.set(false);
		}
	}
}
