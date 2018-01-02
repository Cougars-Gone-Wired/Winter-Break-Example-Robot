package org.usfirst.frc.team2996.robot;

public class DeadZone {
	
	public static double deadZone(double x) {
		if (Math.abs(x) > 0.15) {
			return x;
		} else {
			return 0;
		}
	}
}
