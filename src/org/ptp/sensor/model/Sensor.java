package org.ptp.sensor.model;

import java.awt.Point;
import java.util.UUID;

public class Sensor {
	
	public Sensor(UUID id, Point location, double bearings) {
		super();
		this.id = id;
		this.location = location;
		this.bearings = bearings;
	}
	
	public Sensor(Point location, double bearings) {
		super();
	
		this.location = location;
		this.bearings = bearings;
	}

	private UUID id = UUID.randomUUID();
	
	private Point location;
	
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

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
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
