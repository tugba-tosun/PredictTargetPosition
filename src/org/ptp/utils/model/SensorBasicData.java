package org.ptp.utils.model;

import java.awt.Point;
import java.util.UUID;

public class SensorBasicData{
	
	private UUID id;
	
	private Point location;

	public SensorBasicData(UUID id, Point location) {
		
		this.id = id;
		this.location = location;
	}

	public SensorBasicData() {
		// TODO Auto-generated constructor stub
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

}
