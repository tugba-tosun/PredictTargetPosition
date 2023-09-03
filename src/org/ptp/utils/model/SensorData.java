package org.ptp.utils.model;

import java.awt.Point;
import java.util.UUID;

public class SensorData extends SensorLocation{
	
	private double bearings;


	public SensorData(UUID id, Point location,double bearings) {
		super(id, location);
		this.bearings = bearings;
	}

	public double getBearings() {
		return bearings;
	}

	public void setBearings(double bearings) {
		this.bearings = bearings;
	}

}
