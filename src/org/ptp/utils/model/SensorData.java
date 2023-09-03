package org.ptp.utils.model;

import java.awt.Point;
import java.util.UUID;

public class SensorData extends SensorLocation{
	
	private double bearings;


	public SensorData(UUID id, PhysicalEntity phyEntity,double bearings) {
		super(id, phyEntity);
		this.bearings = bearings;
	}

	public SensorData( PhysicalEntity phyEntity,double bearings) {
		this(UUID.randomUUID(), phyEntity,bearings);
	
	}
	
	public double getBearings() {
		return bearings;
	}

	public void setBearings(double bearings) {
		this.bearings = bearings;
	}
	
	

}
