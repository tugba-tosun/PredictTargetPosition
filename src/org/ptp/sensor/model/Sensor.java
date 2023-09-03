package org.ptp.sensor.model;

import java.awt.Point;
import java.util.UUID;

import org.ptp.utils.model.PhysicalEntity;

public class Sensor extends PhysicalEntity{
	
	public Sensor(UUID id, Point location, double bearings) {
		super(location);
		this.id = id;
		this.bearings = bearings;
	}
	
	public Sensor(Point location, double bearings) {
		super(location);
	
		this.bearings = bearings;
	}

	private UUID id = UUID.randomUUID();
	
	private double bearings;
	
	private boolean active =false;

	public Sensor() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public double getBearings() {
		return bearings;
	}

	public void setBearings(double bearings) {
		this.bearings = bearings;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
