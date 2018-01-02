package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Toggle {
	private boolean buttonState;
	private boolean output = false;
	
	private Joystick stick;
	private int buttonNumber;
	
	public Toggle(Joystick stick, int buttonNumber) {	
		this.stick = stick;
		this.buttonNumber = buttonNumber;
	}
	
	public boolean toggle() {
		if (stick.getRawButton(buttonNumber)) {
			if(!buttonState) {
				output = !output;
			}
			buttonState = true;
		} else {
			buttonState = false;
		}
		return output;
	}
}
